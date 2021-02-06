package code.day22;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {

    @Test
    public void testObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
        oos.writeObject(new String("你好"));
        oos.flush();
        oos.writeObject(new Person("wzh", 22, 1,new Account(123)));
        oos.flush();
        oos.close();
    }

    @Test
    public void testObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Object.dat"));
        Object o = ois.readObject();
        System.out.println(o);
        o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
