package sopt.org.firstSeminar.OOP.polymorphism;


// 본래 하나의 파일에 하나의 클래스가 원칙이지만,
// public class(한파일당 하나, 파일의 이름)과 class들의 조합도 가능은 함
// 그러나 권장되지는 않는다!



//제네릭의 사용위치 1. 클래스, 인터페이스 내부

import java.util.ArrayList;

class GenericClass <T, E, S> {
    T type;
    //여러개의 제네릭 사용가능
    E element;

    S string;

    public S IsGenericMthod(T type){
        //제네릭은 런타임으로 지정되지만, 제네릭으로 들어오는 타입을 구체적으로 코드상을 명사할 경우 컴파일 에러
        //return element.getClass().getName();
        return string;
    }


    // 제네릭의 사용위치 2. 메소드 내부
    // 클래스, 인터페이스에서 지정된 제너릭을 사용할수도 있으나 < > 안의 제네릭은 메소드 범위 내의 제네릭임으로
    // GenericClass의 S와 동일한 키워드지만 메소드 자체 키워드이다.
    // 같은 키워드를 쓰지 않도록 주의해서 사용해자
    public <S> S genericMethod1(S type){
        return type;
    }
    //메소드의 < > 안의 키워드가 아닌 키워드는 클래스(또는 인터페이스) 안이기에 클래스의 키워드를 쓸 수 있다.
    public <S> E genericMethod2(E type1, S type2){
        System.out.println(type1.getClass().getName());

        System.out.println(type2.getClass().getName());

        return type1;
    }

    // 메소드 자체 키워드 K는 메소드의 두번째 매개변수에 따라 바뀌지만 T는 클래스 선언시 정해진 제네릭 타입을 띠리야 한다.
    public <K,V> T genericMethod3(T type1, K type2, V type3){
        System.out.println(type2.getClass().getName());
        System.out.println(type3.getClass().getName());

        return type1;
    }
}

// interface GenericTest <T> {}
public class GenericTest {
    public static void main(String[] args){
        GenericClass<Integer, Double, String> genericClass = new GenericClass<Integer,Double, String>();

        Double d = 10.3;
        Integer i = 3;
        //genericClass.IsGenericMthod(d); //컴파일 에러남
        String s = genericClass.IsGenericMthod(i);
        System.out.println(s);

        String a = genericClass.genericMethod1("wow");
        System.out.println(a);

        Integer b = genericClass.genericMethod1(i);
        System.out.println(b);

        Double dd = genericClass.genericMethod2(d, i);
        System.out.println(dd);

        //Integer ii = genericClass.genericMethod2(i, d); //컴파일 에러
        //System.out.println(ii);

        Integer ig = genericClass.genericMethod3(i,new ArrayList(), new Object());
        System.out.println(ig);

        Integer ih = genericClass.genericMethod3(i,new String(), new Double(11.1));
        System.out.println(ih);

        //Integer ij = genericClass.genericMethod3(new ArrayList(),i, new Object()); //컴파일 에러



    }
}
