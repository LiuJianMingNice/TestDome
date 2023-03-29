package com.example.liuwangshu.light.设计模式.factory.build;

/**
 * ClassName:Builder
 * Package:com.example.liuwangshu.light.factory.build
 *
 * @date:21-6-3
 * @author:liujianming
 */
public abstract class Builder {
    public abstract void buildCpu(String cpu);
    public abstract void buildMainBoard(String mainBoard);
    public abstract void buildRam(String ram);
    public abstract Computer create();
}
