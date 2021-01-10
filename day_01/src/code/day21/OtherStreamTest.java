package code.day21;

import org.junit.Test;

import java.io.*;

public class OtherStreamTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String data;
        while(true){
            data=br.readLine();
            if("e".equals(data)||"exit".equals(data)) {
                System.out.println("结束");
                break;
            }

            System.out.println(data.toUpperCase());
        }
        br.close();
    }
    @Test
    public void test2() throws FileNotFoundException {
        PrintStream ps=new PrintStream(new FileOutputStream("text.txt"),true);
        System.setOut(ps);//把标准输出流改为文件
        for (int i = 0; i < 255; i++) {
            System.out.print((char)i);
            if(i%50==0)
                System.out.println();
        }
        ps.close();
    }
    //数据流，用于读取或写成基本数据类型的变量或字符串
    @Test
    public void test3() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("hello3.txt"));
        dos.writeUTF("你好");
        dos.flush();
        dos.writeDouble(123.00);
        dos.flush();
        dos.close();
}
    @Test
    public void test4() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("hello3.txt"));
        String s = dis.readUTF();
        System.out.println(s);
        double v = dis.readDouble();
        System.out.println(v);
    }
    }


