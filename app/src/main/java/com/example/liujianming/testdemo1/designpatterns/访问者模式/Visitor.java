package com.example.liujianming.testdemo1.designpatterns.访问者模式;

interface Visitor {
    void visit(Music music);
    void visit(Video video);
}
