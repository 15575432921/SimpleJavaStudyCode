package code.day22;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTest3 {
    @Test
    public void client() throws Exception {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello中国".getBytes());
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer=new byte[5];
        int len;
        while((len=is.read(buffer))!=-1)
        {
            baos.write(buffer,0,len);
        }

        System.out.println(baos.toString());
        baos.close();
        is.close();
        outputStream.close();
        socket.close();
    }
    @Test
    public void server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer=new byte[5];
        int len;
        while((len=is.read(buffer))!=-1)
        {
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        System.out.println(socket.getInetAddress().getHostAddress());
        OutputStream os = socket.getOutputStream();
        os.write("发送成功".getBytes());
        os.close();
        baos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
