package sopt.org.firstSeminar.OOP.polymorphism;

//오버 로딩은 같은 메서드가 다른 타입으로 동작하는 것.
public class Calculator {
    Character operator;

    public int add(int a, int b){
        return a+b;
    }

    public double add (double a, double b){
        return a+b;
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        int intResult = calculator.add(1,10);

        // 아래의 경우는 자동병변환이 일어남
        double doubleResult= calculator.add(1,10);

        System.out.println(intResult);
        System.out.println(doubleResult);
    }
}
