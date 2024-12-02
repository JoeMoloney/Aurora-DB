package joe.aurora.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import joe.aurora.domain.UserEntity;
import joe.aurora.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/db/user/getUser")
    public Mono<UserEntity> getUserById(@RequestBody Long userId, HttpServletRequest httpServletRequest) {
        return userService.getUserById(userId)
                .map(response -> {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.convertValue(response, UserEntity.class);
                })
                .doOnError(thrown -> log.error("UserService getUserById Has Thrown An Error: {}", thrown.getMessage()))
                .doOnSuccess(result -> log.info("UserService getUserById Has Completed Successfully: {}", result.toString()));
    }
}
