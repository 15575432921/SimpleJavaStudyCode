package code.day22;



import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class URLTest1 {
    public static void main(String[] args) throws  Exception {
        URL url=new URL("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/5882b2b7d0a20cf49a84743471094b36adaf99c1.jpg");

        HttpsURLConnection urlConnection= (HttpsURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fis=new FileOutputStream(new File("1.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1)
        {
           fis.write(buffer,0,len);
        }
        fis.close();
        is.close();
        urlConnection.disconnect();

    }
}
