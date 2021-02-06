package code.day21;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据
 *  * 2.数据的流向
 *  * 3.流的角色
 * 二、流的体系
 */
public class FileReadWriteTest {
    @Test
    public void test1() {
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //read操作升级 使用read的重载方法
    @Test
    public void test2(){
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] cbuf=new char[5];
            int len ;
            while((len=fileReader.read(cbuf))!=-1){
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
//              String s=new String(cbuf,0,len);
//                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 文件不存在则会自动创建
     * new FileWriter(file,boolean) 默认为false 为覆盖
     */
    @Test
    public void testFileWrite(){
        File file = new File("hello1.txt");
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file,true);
             fileWriter.write("hhh");
            //fileWriter.append("appendTest\n");
            //fileWriter.append("appendTest\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileReadFileWrite(){
        File srcFile = new File("hello.txt");
        File destFile=new File("hello1.txt");
        FileReader fr=null;
        FileWriter fw=null;
        try {
            fr=new FileReader(srcFile);
            fw = new FileWriter(destFile);
            int data;
            char[] cbuf=new char[5];
            int len ;
            while((len=fr.read(cbuf))!=-1) {
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testFileInputStreamFileOutputStream(){
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


