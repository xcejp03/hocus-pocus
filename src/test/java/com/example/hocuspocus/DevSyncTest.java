package com.example.hocuspocus;

import java.util.stream.Stream;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class DevSyncTest {

    private final Faker faker = new Faker();

    @Test
    public void test5() {
        String name = faker.funnyName().name();

        var userWithAddressMono = setAddressForUser(name);

        var result = userWithAddressMono.block();

        log.info("xxx user with address : {}", result);

    }

    public Mono<String> setAddressForUser(String name) {
        var user = getOrCreateUser(name);

        return user.zipWith(getAddressForUser(name))
                   .map(tuple2 -> concatNameAndAddress(tuple2.getT1(), tuple2.getT2()))
                   .flatMap(userWithAddress -> saveUser(userWithAddress)
                           .thenReturn(userWithAddress));
    }

    public Mono<String> getOrCreateUser(String name) {
        return findUserByName(name)
                .switchIfEmpty(createUser(name));
    }

    public String concatNameAndAddress(String name, String address) {
        return name + " - " + address;
    }

    public Mono<String> getAddressForUser(String name) {
        return Mono.just(faker.address().city())
                   .doOnSuccess(s -> log.info("xxx for name '{}' found address '{}'", name, s));
    }

    public Mono<Void> saveUser(String user) {
        return Mono.just(user)
                   .doOnSuccess(s -> log.info("xxx saved user : {}", user))
                   .then();
    }

    public Mono<String> findUserByName(String name) {
        if (faker.bool().bool()) {
            return Mono.empty();
        } else {
            return Mono.just(faker.funnyName().name());
        }
    }

    @Test
    public void test4() {
        processAnimals(5).block();
    }

    private Mono<Void> processAnimals(int count) {
        final var animalFlux = stringProducer(count);

        return animalFlux
                .doOnNext(s -> log.info("xxx animal : {}", s))
                .map(s -> s.toUpperCase())
                .doOnNext(s -> log.info("xxx animal UPPER : {}", s))
                .doOnSubscribe(subscription -> log.info("xxx subscribed"))
                .doOnComplete(() -> log.info("xxx completed"))
                .then();
    }

    private Mono<String> createUser(String name) {
        return Mono.just(name)
                   .doOnSuccess(s -> log.info("xxx name created - {}", s));
    }

    @Test
    public void test3() {
        String testText = "Ja jsem starter text";
        concatItAll(testText).block();
    }

    @Test
    public void testuj() {
        log.info("xxx start test");

        Mono.just("ss")
            .flatMap(x -> {
                log.info("xxx before call {}", x);
                return Mono.just(x);
            })
            .flatMap(s -> getRandomStringMono())
            .flatMap(x -> {
                log.info("xxx after call {}", x);
                return Mono.just(x);
            })
            .block();
    }

    @Test
    public void test2() {
        stringProducer(8)
                .doOnNext(element -> log.info("xxx element : {}", element))
                .map(s -> s.concat("-XXX"))
                .doOnNext(element -> log.info("xxx updated : {}", element))
                .blockLast();
    }

    private Mono<String> concatItAll(String input) {
        return getStringFromExternalService(input)
                .doOnNext(s -> log.info("xxx onNext stringFromExternalService : {}", input))
                .map(s -> s.concat("+X"))
                .flatMap(s -> Mono.just(s.concat("+Y")))
                .map(s -> concatZ(s))
                .flatMap(s -> concatZMono(s))
                .flatMap(s -> returnEmptyRandomly(s))
                .flatMap(s -> {
                    log.info("xxx is it empty? : {}", s);
                    return Mono.just(s);
                })
                .map(s -> {
                    log.info("xxx co ted? je konec? : {}", s);
                    return s;
                })
                //.switchIfEmpty(Mono.error(new RuntimeException("predchazejici kod skoncil na empty")))
                .switchIfEmpty(handleEmpty())
                .then(getRandomColorMono());
    }

    private Mono<String> getStringFromExternalService(String msg) {
        return Mono.just(msg);
    }

    private Mono<String> handleEmpty() {
        log.info("xxx handleEmpty used");
        return Mono.empty();
    }

    private Mono<String> getRandomColorMono() {
        return Mono.just(getRandomColor());
    }

    private Mono<String> getRandomColorDeferMono() {
        return Mono.defer(() -> Mono.just(getRandomColor()));
    }

    private String getRandomColor() {
        log.info("xxx getRandomColor");
        return faker.color().name();
    }

    private String concatZ(String s) {
        return s.concat("+Z");
    }

    private Mono<String> concatZMono(String s) {
        return Mono.just(s.concat("+Z"));
    }

    private Mono<String> returnEmptyRandomly(String s) {
        if (faker.bool().bool()) {
            log.info("xxx returnEmpty ");
            return Mono.empty();
        } else {
            log.info("xxx not empty");
            return Mono.just(s.concat("nebylo empty"));
        }
    }

    private Mono<String> getRandomStringMono() {
        log.info("xxx getRandomStringMono");
        return Mono.just(faker.gameOfThrones().city())
                   .doOnNext(s -> log.info("xxx onNext getRandomStringMono : {}", s))
                   .doOnSubscribe(subscription -> log.info("xxx onSubscribe getRandomStringMono"))
                   .doOnSubscribe(subscription -> log.info("xxx onSuccess getRandomStringMono"));
    }

    private String getRandomString() {
        log.info("xxx getRandomString");
        return faker.gameOfThrones().city();
    }


    private Flux<String> stringProducer(int numberOfElements) {
        return Flux.fromStream(generateFakeData(numberOfElements));

    }


    private Stream<String> generateFakeData(int count) {
        return Stream.iterate("", s -> faker.animal().name())
                     .limit(count)
                     .filter(StringUtils::isNotBlank);

    }

}
