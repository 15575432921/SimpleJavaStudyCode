package code.day19;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args)  {
     //key和value都是String
        FileInputStream inputStream=null;
        try {
            Properties properties = new Properties();
            inputStream = new FileInputStream("jdbc.properties");
            properties.load(inputStream);
            String name=properties.getProperty("name");
            String password=properties.getProperty("password");
            System.out.println(name+" "+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
