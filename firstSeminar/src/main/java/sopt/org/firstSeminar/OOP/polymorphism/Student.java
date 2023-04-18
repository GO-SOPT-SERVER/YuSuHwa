package sopt.org.firstSeminar.OOP.polymorphism;
import sopt.org.firstSeminar.OOP.abstraction.Person;
public class Student  extends Person {
    public Student(int age, String name, String species,String gender, boolean isMarried){
        super(age,name,species,gender,isMarried);

    }
    @Override
    public void work(){
        System.out.println("학생은 공부한다.");
    }



}
