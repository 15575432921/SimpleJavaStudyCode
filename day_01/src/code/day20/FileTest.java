package code.day20;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws FileNotFoundException {
        //File.separator
        File file=new File("test.txt");
        System.out.println(file);
        File file1=new File("D:\\test","a");
        System.out.println(file1);
        File file2=new File(file1,"a.txt");
        System.out.println(file2);
    }
    @Test
    public void test1(){
        File file=new File("test.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));

    }
    @Test
    public void test2(){
        File file=new File("D:\\github\\code\\day_01");
        String[] list = file.list();
        for (String s:
             list) {
            System.out.println(s);
        }
        File[] list1 = file.listFiles();
        for (File s:
                list1) {
            System.out.println(s);
        }
    }
    @Test
    public void test3(){
        File file=new File("D:\\github\\code\\day_01\\test.txt");
        File file1=new File("D:\\github\\code\\day_01\\hello.txt");
        boolean b = file.renameTo(file1);
        System.out.println(b);
    }
    @Test
    public void test4(){
        File file=new File("hello.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    @Test
    public void test5() throws IOException {
        File file=new File("hi.txt");
        if(!file.exists())
        {
            file.createNewFile();
            System.out.println("success");
        }
        else
        {
            file.delete();
            System.out.println("delete");
        }
    }
    @Test
    public void test6(){
        File file=new File("D:\\study\\a\\b");
        boolean mkdir = file.mkdir();
        //boolean mkdirs = file.mkdirs();
        System.out.println(mkdir);

    }
}
