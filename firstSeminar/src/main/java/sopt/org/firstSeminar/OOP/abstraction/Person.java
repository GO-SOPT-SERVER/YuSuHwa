package sopt.org.firstSeminar.OOP.abstraction;

import sopt.org.firstSeminar.OOP.abstraction.Creature;

//추상화 : 불필요한 세부사항을 제거한후 필요한 정보에 따라 본질적이고 "공통적인" 부분만을 추출하여 표현
// 넓은 의미에서 현실세계의 객체를 필요한 부분만을 따와 클래스로 제작하는 것도 추상화
public class Person extends Creature implements livingThing{
    private String gender;
    private boolean isMarried;

    public Person(int age, String name, String species,String gender, boolean isMarried){
        super(age,name,species);
        this.gender=gender;
        this.isMarried=isMarried;
    }
    public void work(){
        System.out.println("사람이 노동한다.");
    }


    @Override
    public void move(){
        System.out.println("사람은 걷습니다.");
    }

    @Override
    public void communicate(){
        System.out.println("사람은 말합니다.");
    }

    @Override
    public void eat(){
        System.out.println("사람은 밥을 먹는다");
    }

    public static void main(String[] args){
        Creature c = new Person(3,"jiji","인간", "여자", false);
        c.move();
        c.communicate();
        //c.work()
        // c.eat(); Person의 인스턴스지만 Creature에 없는 메소드나 변수는 접근 못함
        Person p = new Person(2,"ji","인간", "여자", true);
        p.move();
        p.communicate();
        p.eat();
        p.work();


    }
}

// 좁은 의미에서 공통되는 부분을 뽑아 상위클래스(부모클래스)와 인터페이스로 정의하는것도 추상화
// 이때 추상클래스, 인터페이스로 구현가능하다


//인터페이스 : 함수의 껍데기만 있어 해당 함수의 구현을 강제하기위한 목적, 함수의 구현을 강제하기 떄문에 인터페이스를 구현한 객체의 동작을 보장 할 수 있다.
//특징
// 1. 인터페이스가 인터페이스를 상속가능
// 2. 인터페이스여러개를 하나의 클래스가 다중 구현 가능
// 3. 인터페이스 멤버는 반드시 public : 인터페이스는 그 인터페이스를 구현한 클래스를 어떻게 조작할 것인가를 규정-> 그렇기 때문에 외부에서 제어 할 수 있는 가장 개방적인 접근 제어자인 public만을 허용
// 4. (자바 8 이전에는) 인터페이스는 구체적인 로직이나 상태를 가지고 있을 수 없음 : 모든 메소드가 추상 메소드, 상수와 추상메소드만 가짐
//                  -> //그래서 인터페이스를 구현하는 클래스는 같은 기능이여도 중복으로 기능을 구현해야하는 경우 생김
//      (자바 8이후부터는) 인터페이스에 default 메소드가 추가되어 구체적인 로직을 가진 메소드가 가능해짐. -> 그리고 인터페이스를 구현하는 클래스는 default 메소드를 오버라이딩 가능
//                      인터페이스에 static 메소드가 추각되어 구체적인 로직을 구현할 수 있다. 정적 메소드는 오버라이딩이 불가능하다.
// 5. 인터페이스는 인스턴스를 만들수 없지만 인터페이스를 구현한 클래스를 통하면 인스턴스화가 가능 ex. 인터페이스명 ab = new 클래스명( )


//        그럼 인터페이스에 같은 추상메소드가 있을때 확장받은 오버라이딩은 무엇을 오버라이딩 -> 어차피 인터페이스에는 추상메소드 즉 구현되지 안은 메소드 임으로 무엇을 오버라이딩 했든 상관없음




// 추상 클래스 : 클래스 내 추상 메소드가 하나이상 포함되거나 abstract로 정의된 경우
// 특징
// 1. 상속을 통해 자식 클래스에서 추상 메소드를 구현해 완성을 유도하는 클래스
// 2. 추상메소드와 일반 메소드 둘다 가질 수 있다.
// 3. 추상클래스는 인스턴스를 만들수 없지만 추상클래스를 상속받은 클래스를 통하면 인스턴스화가 가능 ex. 추상클래스명 ab = new 클래스명( )



// 추상클래스와 인터페이스의 차이
// 1. 사용 목적
// : 인터페이스는 구체적인 로직이나 상태를 가지고 있을 수 없고, 추상클래스는 추상메소드 이외에 구체적인 로직이나 상태를 가지고 있기에
// 추상클래스는 기능을 확장시키는데 초점, 인터페이스는 함수의 구현만을 강제
// 2. 추상화정도 : 인터페이스가 추상화정도가 훨씬 높다. 추상클래스는 구체적인로직과 구현을 가질수 았가 때문


