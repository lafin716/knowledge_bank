package com.lafin.knowledge.exam;

public abstract class Wage {

    private int defaultWage;

    private int hour;

    Wage() {
        init();
    }

    private void init() {
        defaultWage = 9160;
        hour = 0;
    }

    public void work(int hour) {
        this.hour += hour;
    }

    public void setWage(int wage) {
        this.defaultWage = wage;
    }

    public abstract void changeWage();

    public void print() {
        int payment = defaultWage * hour;
        System.out.println(defaultWage);
        System.out.println(hour);
        System.out.println("예상 월급 : " + payment + "원");
    }
}
