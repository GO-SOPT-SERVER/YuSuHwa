package sopt.org.firstSeminar.OOP.polymorphism;

//사실 지금 다른 패키지에 있기때문에 같은 이름을 가진 클래스와 인터페이스가 존재는 할 수 있지만
// 같은 이름은 최대한 사용은 안하는게 좋음.
// 물론 이건 연습 코드라서....
public abstract class Person {
    // 추상 클래스에서 추상 메소드조합은 접근 제어자 특성상 public protected만 가능하다.
    //private abstract void turnTurn();
    //default abstract void turnTo();

    protected abstract void turnIn();

    public abstract void walk();
    private String gender;



}
