package code.day16;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable或Comparator
 */
public class CompareTest {
    /*
    1、包装类实现了Comparable接口，重写了compareTo()方法
    2、从小到大
    3、重写compareTo(obj)的规则
     this大于obj返回正整数
     小于负整数
     等于返回0
     */
    @Test
    public void test1(){
        String[] arr=new String[]{"avc","ade","bd","ac"};
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }
    @Test
    public void test2(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("asdas",34);
        arr[1]=new Goods("qqdasd",22);
        arr[2]=new Goods("aasd",34);
        arr[3]=new Goods("qadasd",22);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    Comparator
     */
    @Test
    public void test3(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("asdas",34);
        arr[1]=new Goods("qqdasd",22);
        arr[2]=new Goods("aasd",34);
        arr[3]=new Goods("qadasd",22);
        Arrays.sort(arr,new GoodsComparator());
        System.out.println(Arrays.toString(arr));
    }
}
class GoodsComparator implements Comparator
{

    @Override
    public int compare(Object o1, Object o2) {

        Goods goods=(Goods)o1;
        Goods goods1=(Goods)o2;
        if(goods.getPrice()>goods1.getPrice())
            return 1;
        else if(goods.getPrice()<goods1.getPrice())
            return -1;
        else
            return goods.getName().compareTo(goods1.getName());
    }
}