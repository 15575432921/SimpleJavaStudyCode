package day06;

public class Test {
    public static void main(String[] args) {
        Root a = new Root();
        Root b = new Root();
    }
}
class Root {
    static {
        System.out.println("static");
    }

    {
        System.out.println("普通代码块");
    }

    public Root() {
        System.out.println("构造器");
    }
}
/*
static
普通代码块
构造器
普通代码块
构造器
 */