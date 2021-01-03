package code.day07;

public class FactoryTest {
    public static void main(String[] args) {
        Car audi = CarFactory.getAudi();
        Car audi1 = CarFactory.getCar("audi");

    }
}
class CarFactory
{
    public static Car getAudi(){
        return new Audi();
    }
    public static Car getCar(String  type)
    {
        if("audi".equals(type))
            return  new Audi();
        return null;
    }
}
interface Car{
    
}
class Audi implements Car{
    
}
