package day16;

public class EnumTest {
    public static void main(String[] args) {
        Season spring=Season.SPRING;
        System.out.println(spring.toString());
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
        Season winter = Season.valueOf("WINTER");
        System.out.println(winter);
        System.out.println(winter.name());
        System.out.println(Season.class.getSuperclass());
    }
}
enum Season{
    SPRING("spring","test"),
    SUMMER("summer","test"),
    AUTUMN("autumn","test"),
    WINTER("winter","test");
    private final String seasonName;
    private final String seasonDesc;
    Season(String seasonName,String seasonDesc)
    {
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
}