package code.day22;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTest2 {
    @Test
    public void  test1() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis=new FileInputStream(new File("5.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1)
        {
            os.write(buffer,0,len);
        }
        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void test2()throws IOException{
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos=new FileOutputStream(new File("10.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1)
        {
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
