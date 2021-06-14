package org.firsov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {

    @Autowired
    @Qualifier("dogBean")
    private Pet pet;

    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private int age;

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Autowired
//    public Person(Pet pet) {
//        System.out.println("Person bean was be created");
//        this.pet = pet;
//    }

    public void callYourePet(){
        System.out.println("Hello my lovley Pet!");
        pet.say();
    }


    // pet -> setPet
//    @Autowired
    public void setPet(Pet pet) {
        System.out.println("Class Person set Pet");
        this.pet = pet;
    }

    public Person() {
        System.out.println("Class Person was be created");
    }
}
