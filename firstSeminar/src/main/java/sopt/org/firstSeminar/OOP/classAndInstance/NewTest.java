package sopt.org.firstSeminar.OOP.classAndInstance;


public class NewTest {
    public static void main(String[] args) {
        String dog1 = new String("dog");
        String dog2 = new String("dog");

        // identityHashCode() -> 메모리 주소(저장주소)를 숫자값을로 반환해주는 메서드
        System.out.println(System.identityHashCode(dog1)); //1068934215
        System.out.println(System.identityHashCode(dog2)); //127618319
        // 같은 값(value)을 가진 객체여도 다른 인스턴스임.(각기 다른 메모리주소를 가짐)



        // 간단하게 정리하는 스트링 리터럴과 new 객체의 차이점.
        // new 연산자로 생성된 객체는 Heap 메모리 영역에 생성된다.
        // 스트링 리터럴은 자바 7이전까지는 Pergem안의 string constant pool,
        // 자바 7 부터는 Heap 메모리에 작게 할당된 에 저장 string constant pool 에 저장된다.
        // 문자열 리터럴이 생성될 때마다 JVM은 해당 문자열이 string constant pool에 존재하는지 확인
        // 있으면, 상수 풀에 저장된 기존 문자열을 쓰고
        // 없으면, 상수풀에 새로 저장한다.
        // ! 이때 다른 리터럴 타입(int, bool..) 과 문자열 리터럴은 저장 위치가 다르다 ! 다른 리터럴타입은 일시적으로 스택에 저장됨
        String test1 = "Test";
        String test2 = "Test";
        String test3 = "test";
        String test4 = new String("Test");

        System.out.println(System.identityHashCode(test1)); //1798286609
        System.out.println(System.identityHashCode(test2)); //1798286609
        System.out.println(System.identityHashCode(test3)); //2036958521
        System.out.println(System.identityHashCode(test4)); //1945604815

        test3 = "Test";
        System.out.println(System.identityHashCode(test3)); //1798286609


        // equals 메소드와 '==' 연산자의 차이
        // equals 메소드는 값만 비교
        System.out.println(dog1.equals(dog2));
        // '==' 연산자는 해당 객체의 메모리 주소를 비교
        System.out.println(dog1 == dog2);

        ConvenienceStore cs1 = new ConvenienceStore("gs","서울",4,5);
        ConvenienceStore cs2 = new ConvenienceStore("gs","서울",4,5);


        // equals 메소드는 값만 비교
        System.out.println(cs1.equals(cs2)); //false
        // '==' 연산자는 해당 객체의 메모리 주소를 비교
        System.out.println(cs1 == cs2);//false
        //앞에서 equals 메소드는 값만 비교라고했는데 왜 여기서는 둘다 false지?
        // 이유 -> String의 equals 메소드와 Object의 equals 메소드는 다름.
        // 자바의 모든 객체가 상속받는 최상위 객체인 Object의 equals 메소드는

        /*public boolean equals(Object obj) {
            return (this == obj);
        }*/

        //위와 같다. 내부적으로 주소를 비교하는것!
        // 이 equals 메소드를 다른 객체에서 각자 객체의 특성에 맞게(ex. 문자열은 value가 같으면 true 반환) 오버라이딩하여 사용한다.


    }
}
