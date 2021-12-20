package com.lafin.knowledge.common.impl;

public class Child extends Super {



    @Override
    public void init() {
        super.init();
    }


    public static void main(String[] args) {
        Child child = new Child();
        child.init();

        System.out.println("A : " + child.A);
        System.out.println("Init : " + child.inited);
    }
    
}
