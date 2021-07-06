package com.goggxi.springcreational.bulder;

import com.goggxi.springcreational.prototype.Employee;
import com.goggxi.springcreational.prototype.Position;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BuilderApplication {

    @Bean
    @Scope("prototype")
    public Product productGadget() {
        return Product.builder()
                .category(Category.GADGET)
                .build();
    }

    @Bean
    @Scope("prototype")
    public Product productSpeaker() {
        return Product.builder()
                .category(Category.SPEAKER)
                .build();
    }

}
