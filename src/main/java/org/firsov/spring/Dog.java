package org.firsov.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dogBean")
@Scope("singleton")
public class Dog implements Pet{

    public Dog(){
        System.out.println("Dog was be crated");
    }

    public void say(){
        System.out.println("Bow-wow");
    }

    @PostConstruct
    public void init(){
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Class Dog: destroy method");
    }

}
