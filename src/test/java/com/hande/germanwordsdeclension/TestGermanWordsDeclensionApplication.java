package com.hande.germanwordsdeclension;

import org.springframework.boot.SpringApplication;

public class TestGermanWordsDeclensionApplication {

    public static void main(String[] args) {
        SpringApplication.from(GermanWordsDeclensionApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
