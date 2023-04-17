package sopt.org.firstSeminar.OOP.polymorphism;

public class SportsCar implements Car{
    @Override
    public void turnOn(){
        System.out.println("스포츠차 시동켜기");
    }
    @Override
    public void turnOff(){
        System.out.println("스포츠차 시동끄기");
    }
}
