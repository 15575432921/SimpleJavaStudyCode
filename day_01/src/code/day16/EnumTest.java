package code.day16;

/**
 * 使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class EnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        //toString()返回枚举类对象的名称
        System.out.println(spring.toString());
        //values()返回所有枚举类对象构成的数组
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
        //valueOf(String objName) 返回枚举类中对象名是objName的对象
        Season winter = Season.valueOf("WINTER");
        System.out.println(winter);
        System.out.println(winter.name());
        System.out.println(Season.class.getSuperclass());
        winter.show();
    }
}

interface Info {
    void show();
}

enum Season implements Info {
    //public static final
    SPRING("spring", "test") {
        @Override
        public void show() {
            System.out.println("spring");
        }
    },
    SUMMER("summer", "test") {
        @Override
        public void show() {
            System.out.println("summer");
        }
    },
    AUTUMN("autumn", "test") {
        @Override
        public void show() {
            System.out.println("autumn");
        }
    },
    WINTER("winter", "test") {
        @Override
        public void show() {
            System.out.println("winter");
        }
    };
    private final String seasonName;
    private final String seasonDesc;

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
}