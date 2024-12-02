package joe.aurora.services;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<JsonNode> getUserById(Long userId);
}
