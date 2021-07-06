package com.goggxi.springcreational.factory.method;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = FactoryMethodApplication.class)
class FactoryMethodApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testFactoryInheritance() {
        SocialMedia facebook = applicationContext.getBean(SocialMedia.class, SocialMediaType.FACEBOOK);

        System.out.println(facebook.getName());
        System.out.println(facebook.getUrl());
        System.out.println("--------------------");

        SocialMedia twitter = applicationContext.getBean(SocialMedia.class, SocialMediaType.TWITTER);

        System.out.println(twitter.getName());
        System.out.println(twitter.getUrl());
        System.out.println("--------------------");

        SocialMedia instagram = applicationContext.getBean(SocialMedia.class, SocialMediaType.INSTAGRAM);

        System.out.println(instagram.getName());
        System.out.println(instagram.getUrl());
        System.out.println("--------------------");
    }
}