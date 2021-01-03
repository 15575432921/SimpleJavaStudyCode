package code.day05;

public class Man {
    private int a;

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj instanceof Man){
            return this.a == ((Man) obj).a;
        }
        return  false;
    }


    public static void main(String[] args) {
        int[] arry={1,2,3};

        Man a = new Man();
        if(a instanceof Man)
        {
            System.out.println("hh");
        }
        Integer i=10;
        String s=String.valueOf(i);
        int x=Integer.parseInt(s);
        System.out.println(s);
        System.out.println(i);
    }
}
