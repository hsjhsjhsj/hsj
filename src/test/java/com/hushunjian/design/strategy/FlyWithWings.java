package com.hushunjian.design.strategy;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("有翅膀的飞行!");
    }
}
