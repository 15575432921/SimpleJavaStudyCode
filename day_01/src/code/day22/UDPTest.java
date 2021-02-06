package code.day22;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket  socket = new DatagramSocket();
        String str="你好";
        byte[] data=str.getBytes();
        InetAddress inet=InetAddress.getLocalHost();
        DatagramPacket packet=new DatagramPacket(data,0,data.length,inet,9090);
        socket.send(packet);
        socket.close();

    }
    @Test
    public void receiver()throws IOException{
       DatagramSocket socket=new DatagramSocket(9090);
        byte[] data=new byte[100];
       DatagramPacket packet=new DatagramPacket(data,0,data.length);
       socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
    }
}
