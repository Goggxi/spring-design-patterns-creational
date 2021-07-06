package com.goggxi.springcreational.factory.method;

import lombok.Getter;

@Deprecated
public class FacebookSocialMedia implements SocialMedia {

    @Getter
    private final String name = "FACEBOOK";

    @Getter
    private final String url = "https://facebook.com";

    @Getter
    private final SocialMediaType type = SocialMediaType.FACEBOOK;

}
