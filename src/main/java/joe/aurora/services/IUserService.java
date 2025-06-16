package joe.aurora.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import joe.aurora.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IUserService {

    Mono<User> addUser(User user);

    Flux<User> getAllUsers();

    Mono<User> getUserById(Long userId);
}
