package com.example.liuwangshu.light.设计模式.结构型.外观模式;

/**
 * ClassName:ZhangWuJi
 * Package:com.example.liuwangshu.light.设计模式.结构型.外观模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class ZhangWuJi {

    private ZhaoShi zhaoShi;
    private NeiGong neiGong;
    private JinMai jinMai;

    public ZhangWuJi() {
        zhaoShi = new ZhaoShi();
        neiGong = new NeiGong();
        jinMai = new JinMai();
    }

    public void qianKun() {
        jinMai.JingMai();
        neiGong.QianKun();
    }

    public void jiuYang() {
        jinMai.JingMai();
        neiGong.JiuYang();
        zhaoShi.QiShangQuan();
    }
}
