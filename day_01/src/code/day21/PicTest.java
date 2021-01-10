package code.day21;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {
    @Test
            public void test1(){
        File srcFile = new File("5.jpg");
        File destFile=new File("7.jpg");
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            int data;
            byte[] cbuf=new byte[10];
            int len ;
            long start = System.currentTimeMillis();
            while((len=fis.read(cbuf))!=-1) {
                for (int i = 0; i < len; i++) {
                    cbuf[i]=(byte)(cbuf[i]^5);
                }
                fos.write(cbuf,0,len);
            }
            System.out.println(System.currentTimeMillis()-start);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2(){
        File srcFile = new File("7.jpg");
        File destFile=new File("8.jpg");
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            int data;
            byte[] cbuf=new byte[10];
            int len ;
            long start = System.currentTimeMillis();
            while((len=fis.read(cbuf))!=-1) {
                for (int i = 0; i < len; i++) {
                    cbuf[i]=(byte)(cbuf[i]^5);
                }
                fos.write(cbuf,0,len);
            }
            System.out.println(System.currentTimeMillis()-start);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
