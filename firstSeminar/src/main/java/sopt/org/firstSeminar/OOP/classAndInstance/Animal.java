package sopt.org.firstSeminar.OOP.classAndInstance;

// class : 하나의 역할(관심)을 가지는 단위. 해당 역할(관심)의 수행에 필요한 속성(멤버 변수) 과 행위(메소드)를 가진다 : ex. 쿠키틀
// instance : 클래스를 토대로 실제 메모리를 할당받아 데이터화 된 객체 : ex. 쿠키
public class Animal {
    private String species;
    private String name;
    private int age;

    public void speak(){
        System.out.println("동물이 소리를 냅니다.");
    }

    public void drink(){
        System.out.println("동물이 물을 마십니다.");
    }



    public static void main(String[] args) {
        //new키워드로 객체 인스턴스 생성
        Animal animal = new Animal();
        animal.speak();
        animal.drink();
    }
}
