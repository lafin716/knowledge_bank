package com.lafin.knowledge.exam;

public class GoodCompany extends Wage {

    GoodCompany() {
        changeWage();
    }

    @Override
    public void changeWage() {
        setWage(20000);
    }
}
