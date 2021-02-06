package code.day22;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.10.14");
        System.out.println(address);
        InetAddress address1 = InetAddress.getByName("www.baidu.com");
        System.out.println(address1);
        System.out.println(address1.getHostAddress());
        System.out.println(address1.getHostName());
    }
}
