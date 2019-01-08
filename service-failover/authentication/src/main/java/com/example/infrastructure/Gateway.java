package com.example.infrastructure;

import com.example.domain.UserFacade;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Gateway {

    private UserFacade facade;

    public Gateway(UserFacade facade) {
        this.facade = facade;
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean credentialsMatch(@RequestBody UserDTO user) {
        return facade.credentialsMatch(user.getUsername(), user.getPassword());
    }

}
