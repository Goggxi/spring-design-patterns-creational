package com.goggxi.springcreational.factory.method;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class FactoryMethodApplication {

    @Bean
    @Scope("prototype")
    public SocialMedia socialMedia(SocialMediaType type) {
        if (type == SocialMediaType.FACEBOOK) {
            return new FacebookV2SocialMedia();
        } else if (type == SocialMediaType.INSTAGRAM) {
            return new InstagramSocialMedia();
        } else if (type == SocialMediaType.TWITTER) {
            return new TwitterSocialMedia();
        } else {
            throw new IllegalArgumentException("Unsupported Social media Type");
        }
    }
}
