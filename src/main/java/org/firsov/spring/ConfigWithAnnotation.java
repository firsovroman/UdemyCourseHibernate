package org.firsov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

//        Cat myCat = context.getBean("catBean", Cat.class);
//        myCat.say();

//        Person person = context.getBean("personBean", Person.class);
//        person.callYourePet();
//
//        System.out.println(person.getSurname() + " : " + person.getAge());

            Dog myDog = context.getBean("dogBean", Dog.class);
            Dog myDog2 = context.getBean("dogBean", Dog.class);

        System.out.println("Ссылаются на один и тот же объект  " + (myDog==myDog2));

        context.close();
    }
}
