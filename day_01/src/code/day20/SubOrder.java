package code.day20;

public class SubOrder extends Order<Integer> {
    public static void main(String[] args) {
        //已经指明
        SubOrder subOrder=new SubOrder();
        subOrder.setOrderT(123);
    }
}
//未指明
class SubOrder2<K,V> extends  Order<K>
{
//static V a; 不能静态
}
//异常类不能为泛型
//class MyException<T> extends Exception