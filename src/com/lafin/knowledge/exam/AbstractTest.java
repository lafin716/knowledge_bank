package com.lafin.knowledge.exam;

public abstract class AbstractTest {

    private int money = 0;

    AbstractTest() {
        init();
    }

    public void init() {
        money = 1;
    }

    public abstract void multiply(int a);

    public void print() {
        System.out.println("money : " + money);
    }
}
