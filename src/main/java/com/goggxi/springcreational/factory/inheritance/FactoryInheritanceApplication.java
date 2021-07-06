package com.goggxi.springcreational.factory.inheritance;

import com.goggxi.springcreational.factory.method.FacebookV2SocialMedia;
import com.goggxi.springcreational.factory.method.InstagramSocialMedia;
import com.goggxi.springcreational.factory.method.SocialMedia;
import com.goggxi.springcreational.factory.method.TwitterSocialMedia;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class FactoryInheritanceApplication {

    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaFacebook() {
        return new FacebookV2SocialMedia();
    }

    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaInstagram() {
        return new InstagramSocialMedia();
    }

    @Bean
    @Scope("prototype")
    public SocialMedia socialMediaTwitter() {
        return new TwitterSocialMedia();
    }
}
