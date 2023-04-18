package sopt.org.firstSeminar.OOP.abstraction;

// 추상 클래스 : 클래스 내 추상 메소드가 하나이상 포함되거나 abstract로 정의된 경우
// 특징
// 1. 상속을 통해 자식 클래스에서 추상 메소드를 구현해 완성을 유도하는 클래스
// 2. 추상메소드와 일반 메소드 둘다 가질 수 있다.
// 3. 추상클래스는 인스턴스를 만들수 없지만 추상클래스를 상속받은 클래스를 통하면 인스턴스화가 가능 ex. 추상클래스명 ab = new 클래스명( )


public abstract class Creature {
    private String species;
    private String name;
    private int age;

    public Creature(int age, String name, String species){
        this.age = age;
        this.species=species;
        this.name=name;
    }

    public void age(){
        age++;
    }

    public String getSpecies(){
        return this.species;
    }

    public String getName(){
        return this.name;
    }

    public abstract void move();
    public abstract void communicate();

}
