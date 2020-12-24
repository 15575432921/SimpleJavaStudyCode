package test;


public class Foo{
    public static void main (String[] args){

        String s = "hello";

        String t = "hello";

        char c[] = {'h','e','l','l','o'} ;
        System.out.println(t==new String("hello"));
    }
}