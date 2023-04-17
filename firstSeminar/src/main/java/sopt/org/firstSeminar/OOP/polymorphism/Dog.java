package sopt.org.firstSeminar.OOP.polymorphism;

import sopt.org.firstSeminar.OOP.classAndInstance.Animal;

//사실 지금 다른 패키지에 있기때문에 같은 이름을 가진 클래스가 존재는 할 수 있지만
// 이런 이름이 같은 클래스 사용은 안하는게 좋음.
// 물론 이건 연습 코드라서....
public class Dog extends Animal {
    private String gender;

    public void walk(){
        System.out.println("개가 산책한다.");

    }

    // 오버라이딩은 자식 객체가 상속받는 부모객체의 메소드와 정확히 같은 메소드를 오버라이딩(재정의) 할 수 있다.
    @Override
    public void speak(){
        System.out.println("개가 짖는다.");
    }
}