package sopt.org.firstSeminar.OOP.inheritance;

import sopt.org.firstSeminar.OOP.classAndInstance.Animal;

public class Dog extends Animal {
    private String gender;

    public void walk(){
        System.out.println("개가 산책한다.");
    }

    public void bark(){
        System.out.println("개가 짖는다.");
    }

    public static void main(String[] args){
        Dog doggie1 = new Dog();

        // 부모 객체를 자식객체로 형변환 가넝~
        Animal doggie2 = new Dog();

        // 자식객체를 부모객체로 형변환? 불가능 컴파일 에러납니다.
        //Dog doggie3 = new Animal();


        doggie1.drink();
        doggie1.speak();
        doggie2.drink();
        doggie2.speak();

        //부모객체로 정의된 인스턴스는 자식객체의 고유 메소드를 사용하지 못한다.
        // 당연함 그것이.... 타입정의임
        doggie1.walk();
        doggie1.bark();
        //doggie2.walk(); //컴파일 에러나유
        //doggie2.bark(); //컴파일 에러2
    }
}
