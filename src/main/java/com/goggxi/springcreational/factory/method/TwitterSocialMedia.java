package com.goggxi.springcreational.factory.method;

import lombok.Getter;

public class TwitterSocialMedia implements SocialMedia{

    @Getter
    private final String name = "TWITTER";

    @Getter
    private final String url = "https://twitter.com";

    @Getter
    private final SocialMediaType type = SocialMediaType.TWITTER;

}
