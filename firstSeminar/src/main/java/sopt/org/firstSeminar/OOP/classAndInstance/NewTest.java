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
        // ! 이때 다른 리터럴 타입(int, bool..) 과 문자열 리터럴은 저장 위치가 다르다 !
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



    }
}
