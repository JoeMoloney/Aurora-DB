package joe.aurora.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.r2dbc.h2.H2Row;
import jakarta.servlet.http.HttpServletRequest;
import joe.aurora.domain.User;
import joe.aurora.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/db/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public Mono<User> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAllUsers")
    public Flux<H2Row> getAllUsers() {
        return userService.getAllUsers()
                .log();
    }

    @GetMapping("/getUser/{userId}")
    public Mono<User> getUserById(@PathVariable Long userId, HttpServletRequest httpServletRequest) {
        return userService.getUserById(userId);
    }
}
