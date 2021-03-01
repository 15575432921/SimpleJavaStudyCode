package csdn;

import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x=(int)(Math.random()*100);
        int i = in.nextInt();
        switch (i)
        {
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            default:
                System.out.println("OTHER");
        }
        System.out.println(i);
    }


}
