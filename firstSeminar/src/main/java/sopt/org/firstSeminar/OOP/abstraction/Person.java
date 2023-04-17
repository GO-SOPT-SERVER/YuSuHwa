package sopt.org.firstSeminar.OOP.abstraction;

public class Person {
    private String gender;
    private  int age;
    private String name;
    private boolean isMarried;

    public void walk(){
        System.out.println("사람이 걷는다.");
    }

    public void talk(){
        System.out.println("사람이 말한다.");
    }
}
