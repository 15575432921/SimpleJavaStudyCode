package code.day22;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.注解继承于java.lang.Object类，实现了DataInput 和DataOutput接口
 * 2.即可作为输入流，也可作为输出流
 * 3.作为输出流时，写出的文件如果不存在，则新建
 * 否则为从头覆盖
 */
public class RandomAccessFileTest {
    @Test
    public void test1() throws IOException {
        RandomAccessFile file=new RandomAccessFile("5.jpg","r");
        RandomAccessFile file2=new RandomAccessFile("9.jpg","rw");
        byte[]buff=new byte[1024];
        int len;
        while((len=file.read(buff))!=-1)
        {
            file2.write(buff,0,len);
        }
        file.close();
        file2.close();
    }
    @Test
    public void test2() throws IOException{
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.close();
    }
    @Test
    public void test3()throws IOException{
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);
        StringBuilder builder=new StringBuilder((int) new File("hello.txt").length());
        byte [] buffer=new byte[20];
        int len;
        while((len=raf1.read(buffer))!=-1)
        {
             builder.append(new String(buffer,0,len));
        }
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.write(builder.toString().getBytes());
        raf1.close();
    }
    //避免乱码
    @Test
    public void test4()throws IOException{
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte [] buffer=new byte[20];
        int len;
        while((len=raf1.read(buffer))!=-1)
        {
            baos.write(buffer,0,len);
        }
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.write(baos.toString().getBytes());
        raf1.close();
    }
}
