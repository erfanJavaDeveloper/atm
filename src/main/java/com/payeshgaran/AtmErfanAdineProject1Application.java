package com.payeshgaran;

import com.payeshgaran.entity.Account;
import com.payeshgaran.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

import static com.payeshgaran.entity.TypeOfAccount.*;

@SpringBootApplication
public class AtmErfanAdineProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(AtmErfanAdineProject1Application.class, args);


    }


    @Bean
    CommandLineRunner run(AccountService accountService)
    {
        return args -> {
            accountService.saveWithOutDto(new Account("6038","123", BigDecimal.valueOf(10000),LONG_TERM ));
            accountService.saveWithOutDto(new Account("6037","123",BigDecimal.valueOf(20000000), SHORT_TERM ));
            accountService.saveWithOutDto(new Account("6039","123",BigDecimal.valueOf(25000),LOANS));

        };
    }


}
