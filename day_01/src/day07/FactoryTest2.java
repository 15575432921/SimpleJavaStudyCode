package day07;

public class FactoryTest2 {
    public static void main(String[] args) {
        Car audi =new  AudiFactory().getCar();
    }
}
interface Factory{
    Car getCar();
}
class AudiFactory implements Factory
{
    public   Car getCar(){
        return new Audi();
    }

}
/*
interface Car{

}
class Audi implements Car{

}
*/