package joe.aurora.services;

import com.fasterxml.jackson.databind.JsonNode;
import joe.aurora.domain.User.UserEntity;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<JsonNode> getUserById(Long userId);
}
