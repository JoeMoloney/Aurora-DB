package joe.aurora.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import joe.aurora.domain.UserEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<UserEntity, Long> {

    @Query("SELECT u FROM users WHERE u.userId = CAST(:userId AS LONG)")
    Mono<JsonNode> getUserById(Long userId);
}
