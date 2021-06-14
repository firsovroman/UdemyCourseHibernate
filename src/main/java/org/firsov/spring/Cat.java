package org.firsov.spring;

import org.springframework.stereotype.Component;

@Component("catBean")
public class Cat implements Pet {
    public Cat(){
        System.out.println("Cat was be created");
    }

    public void say(){
        System.out.println("Meow-meow");
    }
}
