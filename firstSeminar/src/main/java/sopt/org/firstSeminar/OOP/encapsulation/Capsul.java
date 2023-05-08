package sopt.org.firstSeminar.OOP.encapsulation;

public class Capsul {
    //접근제어자 범위
    private int p;
    //클래스 안에서만 사용가능
    int d;
    // default는 클래스안, 같은 패키지 안까지 사용가능
    protected int pp;
    //클래스 안, 같은 패키지, 상속받은 자식클래스까지는 사용가능
    public int c;
    // 모든 곳에서 접근 가능

}
