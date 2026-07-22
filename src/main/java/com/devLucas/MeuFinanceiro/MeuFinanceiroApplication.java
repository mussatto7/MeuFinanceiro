package com.devLucas.MeuFinanceiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MeuFinanceiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeuFinanceiroApplication.class, args);
    }

}
