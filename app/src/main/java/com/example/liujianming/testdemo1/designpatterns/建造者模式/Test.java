package com.example.liujianming.testdemo1.designpatterns.建造者模式;

public class Test {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();//创建建造者实例，（装机人员）
        Director direcror = new Director(builder);//创建指挥者实例，并分配相应的建造者，（老板分配任务）
        direcror.Construct("i7-6700", "三星DDR4", "希捷1T");//组装电脑
    }
}
