package code.day20;

import org.junit.Test;

import java.util.List;

public class Order<T> {
    String orderName;
    T orderT;
    T [] arr =(T []) new Object[10];
    public Order(){}
    public Order(String orderName,T orderT)
    {
        this.orderName=orderName;
        this.orderT=orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
//不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
    //泛型方法 可以static
    public static <E> E test(E e){
        return e ;
    }
    public static void main(String[] args) {
        Order<String> order = new Order<String>("hello", "world");
        System.out.println(order.getOrderName()+" "+order.getOrderT());
        Integer t = order.test(123);
        System.out.println(t);
    }
    /**
     * 通配符？
     */
    @Test
    public void test1(){
        List<Object> list1=null;
        List<String> list2=null;
        List<?>list=null;
        list=list1;
        list=list2;
        List<? super Object>list3;
        List<? extends String>list4;
        //list4=list1;报错
        list4=list2;
        //list3=list2;报错
        list3=list1;

    }
}
