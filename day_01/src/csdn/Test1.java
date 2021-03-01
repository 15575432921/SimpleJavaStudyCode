package csdn;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x=(int)(Math.random()*100);
        int i ;
        while ((i = in.nextInt())!=x)
        {
            if(i<x){
                System.out.println("<");
            }
            else
            {
                System.out.println(">");
            }
        }
        System.out.println(x);
    }
}
