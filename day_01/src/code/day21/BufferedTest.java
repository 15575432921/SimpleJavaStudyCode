package code.day21;

import org.junit.Test;

import java.io.*;

public class BufferedTest {
   @Test
       public void BufferedStreamTest(){
           File srcFile = new File("5.jpg");
           File destFile=new File("6.jpg");
           FileInputStream fis=null;
           FileOutputStream fos=null;
           BufferedInputStream bis=null;
           BufferedOutputStream bos=null;
           try {
               fis=new FileInputStream(srcFile);
               fos = new FileOutputStream(destFile);
               bis=new BufferedInputStream(fis);
               bos = new BufferedOutputStream(fos);
               int data;
               byte[] cbuf=new byte[10];
               int len ;
               long start = System.currentTimeMillis();
               while((len=bis.read(cbuf))!=-1) {
                   bos.write(cbuf,0,len);
               }
               System.out.println(System.currentTimeMillis()-start);
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               //在关闭外层流的同时，内层也会自动关闭
               if (bis != null) {
                   try {
                       bis.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               if (bos != null) {
                   try {
                       bos.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
   }
    @Test
    public void BufferedStreamTest2(){
        File srcFile = new File("5.jpg");
        File destFile=new File("6.jpg");
        FileInputStream fis=null;
        FileOutputStream fos=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            fis=new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            bis=new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            int data;
            long start = System.currentTimeMillis();
            while((data=bis.read())!=-1) {
                bos.write(data);
            }
            System.out.println(System.currentTimeMillis()-start);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在关闭外层流的同时，内层也会自动关闭
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
