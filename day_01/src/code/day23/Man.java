package code.day23;
@MyAnnotation()
public class Man extends Creature<String> implements Comparable<String>,MyInterface {
    private  String name;
    int age;
    public int id;
    public Man(){}
    private Man(String name) {
        this.name = name;
    }

     Man(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println(nation);
        return nation;
    }
    public String display(String interest,int age) throws  NullPointerException,ClassCastException{
        return interest;
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个男人");
    }
    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
