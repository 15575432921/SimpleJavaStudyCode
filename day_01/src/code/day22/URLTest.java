package code.day22;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=628");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
    }
}
