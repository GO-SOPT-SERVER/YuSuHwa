package sopt.org.firstSeminar.OOP.polymorphism;

public interface Car {
    public abstract void turnOn();
    void turnOff();
    // 어차피 인터페이스 내부의 메서드는 전부 추상메서드라서 굳이 표기안해도 public abstract가 기본

    //인터페이스는 추상메소드로만 이루어져야하는데, 접근제어자의 특성상 public+abstract 조합밖에는 되지 않습니다.
    //private abstract void turnTurn();
    //protected abstract void turnIn();
    //default abstract void turnTo();
}
