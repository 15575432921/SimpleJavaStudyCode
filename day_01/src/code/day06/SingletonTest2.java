package code.day06;

public class SingletonTest2 {
    public static void main(String[] args) {
        Order o1=Order.getInstance();
        Order o2=Order.getInstance();
        System.out.println(o1==o2);
    }
}
//懒汉式
class Order
{
    private Order(){

    }
    private static volatile Order instance=null;
    //线程不安全
    /*
    public static Order getInstance()
    {
        if(instance==null)
        {
            instance=new Order();
        }
        return  instance;

    }
    */

   public  static  Order getInstance()
   {
       if(instance==null)
       {
           synchronized (Order.class)
           {
               if(instance==null)
                   instance=new Order();
           }
       }
       return  instance;
   }
}