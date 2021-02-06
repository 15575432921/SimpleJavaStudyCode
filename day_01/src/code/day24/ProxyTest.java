package code.day24;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    String getBelief();
    void eat(String food);
}
class SuperMan implements Human
{

    @Override
    public String getBelief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
class HumanUtil{
    public static void method1(){
        System.out.println("通用方法一");
    }
    public static  void method2(){
        System.out.println("通用方法二");
    }
}
class ProxyFactory{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces()
                ,handler);
    }
}
class  MyInvocationHandler implements InvocationHandler{
private Object obj ;
public void bind(Object obj){
    this.obj =obj;
}
    //当我们通过代理类的对象，调用方法a时就会自动的调用如下的方法invoke
    //将被代理类要执行的方法a的功能就声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //代理类对象调用的方法,此方法也 就作为了被代理类对象要调用的方法
        HumanUtil.method1();
        Object returnValue = method.invoke(obj, args);
        HumanUtil.method2();
        return  returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan=new SuperMan();
        Human proxy=(Human)ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxy.getBelief());
        proxy.eat("四川麻辣烫");
        NikeClothFactory nikeClothFactory=new NikeClothFactory();
        ClothFactory proxyInstance = (ClothFactory)ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance.produceCloth();
    }
}
