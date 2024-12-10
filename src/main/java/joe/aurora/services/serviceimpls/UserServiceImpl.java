package joe.aurora.services.serviceimpls;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.r2dbc.h2.H2Row;
import joe.aurora.domain.User;
import joe.aurora.repositories.UserRepository;
import joe.aurora.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> addUser(User user) {
        return userRepository.addUser(user.getFName(), user.getLName())
                .map(response -> {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.convertValue(response, User.class);
                })
                .doOnError(thrown -> log.error("UserService addUser Has Thrown An Error: {}", thrown.getMessage()))
                .doOnSuccess(result -> log.info("UserService addUser Has Completed Successfully"));
    }

    @Override
    public Flux<H2Row> getAllUsers() {
        return userRepository.getAllUsers()
                .doOnError(thrown -> log.error("UserService getAllUsers Has Thrown An Error: {}", thrown.getMessage()));
    }

    @Override
    public Mono<User> getUserById(Long userId) {
        return null;
    }
}
