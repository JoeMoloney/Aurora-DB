package joe.aurora.services.serviceimpls;

import com.fasterxml.jackson.databind.JsonNode;
import joe.aurora.repositories.UserRepository;
import joe.aurora.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<JsonNode> getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }
}
