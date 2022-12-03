package com.example.hocuspocus.allterrain;

public interface Visitor {

    void visit(FlyMotion flyMotion);

    void visit(DriveMotion driveMotion);

    void visit(SwimMotion swimMotion);


}
