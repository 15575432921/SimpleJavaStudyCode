package code.day06;

public class SingletonTest1 {
    Bank s=Bank.getInstance();

}
//饿汉式
class Bank{
    private Bank(){

    }
    private static Bank instance=new Bank();
    public static Bank getInstance()
    {
        return instance;
    }
}
