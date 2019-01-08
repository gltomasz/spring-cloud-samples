package com.example.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
class AppConfiguration {

    @Bean
    UserRepository repository() {
        return new UserRepository();
    }

    @Bean
    UserFacade facade() {return new UserFacade(repository());}

}
