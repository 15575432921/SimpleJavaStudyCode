package code.day24.Optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
        Girl girl1=null;
        //Optional.of(girl1);
        Optional<Girl> optionalGirl1 = Optional.ofNullable(girl1);
        Girl girl2 = optionalGirl1.orElse(new Girl("wzh"));
        System.out.println(girl2);
    }
    public String getGirlName(Boy boy)
    {
        return boy.getGirl().getName();
    }
    public String getGirName2(Boy boy)
    {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl=boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));
        return  girl1.getName();
    }
    //orElse和get
    //ofNullable 和orElse
    @Test
    public void test2(){
        Boy boy=new Boy();
        //boy=null;
        //boy=new Boy(new Girl("wzh"));
        String s = getGirName2(boy);
        System.out.println(s);
    }

    @Test
    public void  test3(){
        Optional<Object> op1 = Optional.empty();
        if(!op1.isPresent())
        {
            System.out.println("empty");
        }
        System.out.println(op1);
    }
    @Test
    public void test4(){
        String str="hello";
        Optional<String> op1 = Optional.of(str);
        System.out.println(op1.get());
    }
}
