package com.goggxi.springcreational.factory.inheritance;

import com.goggxi.springcreational.factory.method.SocialMedia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = FactoryInheritanceApplication.class)
class FactoryInheritanceApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testFactoryInheritance() {
        SocialMedia facebook = applicationContext.getBean("socialMediaFacebook", SocialMedia.class);
        SocialMedia instagram = applicationContext.getBean("socialMediaInstagram", SocialMedia.class);
        SocialMedia twitter = applicationContext.getBean("socialMediaTwitter", SocialMedia.class);

        System.out.println(facebook);
        System.out.println(instagram);
        System.out.println(twitter);
    }
}