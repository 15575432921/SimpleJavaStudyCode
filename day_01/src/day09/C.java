package day09;
import java.text.SimpleDateFormat;
import java.util.Date;

public   class C {
    public static void main(String[] args) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间为: " + ft.format(dNow));
    }
}
