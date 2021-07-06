package com.goggxi.springcreational.bulder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BuilderApplication.class)
class BuilderApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void productBCategory() {
        Product iphone = applicationContext.getBean("productGadget", Product.class);
            iphone.setName("iphone 12 Pro");
            iphone.setPrice(25_000_000L);

        System.out.println(iphone);
    }

    @Test
    void setProduct() {
        Product iphone = Product.builder()
                .id("xxx")
                .name("Iphone X")
                .price(10_000_000L)
                .category(Category.GADGET)
                .build();

        Product laptop = Product.builder()
                .id("xxx")
                .name("Asus Duo")
                .price(30_000_000L)
                .category(Category.LAPTOP)
                .build();

        System.out.println(iphone);
        System.out.println(laptop);
    }
}