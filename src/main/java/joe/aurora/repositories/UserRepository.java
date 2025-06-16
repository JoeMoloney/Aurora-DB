package joe.aurora.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import joe.aurora.domain.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    @Query("INSERT INTO users (fName, lName) VALUES (:fName, :lName)")
    Mono<JsonNode> addUser(String fName, String lName);

    @Query("SELECT * FROM users")
    Flux<User> getAllUsers();

    @Query("SELECT u User FROM u users WHERE u.fName = :fName AND u.lName = :lName")
    Mono<JsonNode> getUserByName(String fName, String lName);
}
