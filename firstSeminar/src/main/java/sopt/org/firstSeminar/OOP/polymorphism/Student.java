package sopt.org.firstSeminar.OOP.polymorphism;

import sopt.org.firstSeminar.OOP.abstraction.Person;

public class Student extends Person {
    @Override
    public void walk(){
        System.out.println("학교를 향해 걷는다.");
    }
}
