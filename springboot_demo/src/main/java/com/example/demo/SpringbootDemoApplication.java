package com.example.demo;

import com.example.demo.entity.Cat;
import com.example.demo.entity.Shop;
import com.example.demo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;

@Import({User.class})
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemoApplication.class, args);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Cat tom = run.getBean("tom", Cat.class);
        System.out.println(tom.getName());
        User user = run.getBean("user", User.class);
        //@Configuration(proxyBeanMethods = false)为false则结果为false 反之亦然
        System.out.println(user.getCat() == tom);
        String[] userNames = run.getBeanNamesForType(User.class);
        for (String username:userNames
        ) {
            System.out.println(username);
        }
        String[] catNames = run.getBeanNamesForType(Cat.class);
        for (String catname:catNames
        ) {
            System.out.println(catname+" "+run.getBean(catname, Cat.class).getName());
        }
        for (String name:run.getBeanNamesForType(MultipartResolver.class)
        ) {
            System.out.println(name);
        }
        Shop shop = run.getBean("shop", Shop.class);
        System.out.println(shop.cat.getName());
    }

}
