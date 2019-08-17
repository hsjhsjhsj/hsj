package com.hushunjian.design.strategy;

import lombok.Data;

@Data
public class Duck {

    public FlyBehavior flyBehavior;

    public QuackBehavior quackBehavior;

    public void swim(){

    }

    public void display(){

    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }
}
