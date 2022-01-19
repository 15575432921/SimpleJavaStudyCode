package day16;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigTest {
    @Test
    public void test1(){
        BigInteger integer=new BigInteger("12344443423423");
        System.out.println(integer);
        BigDecimal decimal=new BigDecimal("1234.34634534");
        BigDecimal decimal1=new BigDecimal("11");
        System.out.println(decimal.divide(decimal1,BigDecimal.ROUND_HALF_UP));
    }
}
