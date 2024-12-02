package joe.aurora.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.Optional;

@Configuration
@EnableR2dbcRepositories(basePackages = "joe.aurora.repositories", entityOperationsRef = "auroraR2dbcEntityTemplate")
public class AuroraDataSourceConfig {

    private static final String CONFIG_PROPERTIES_PREFIX = "spring.r2dbc.aurora:";

    @Primary
    @Bean(name = "auroraR2dbcEntityTemplate")
    public R2dbcEntityTemplate r2dbcEntityTemplate(@Qualifier("auroraConnectionFactory") ConnectionFactory connectionFactory) {
        return new R2dbcEntityTemplate(connectionFactory);
    }

    @Primary
    @Bean(name = "auroraR2dbcEntityTemplate")
    public ConnectionFactory connectionFactory(Environment environment) {
        String url = Optional.ofNullable(environment.getProperty(CONFIG_PROPERTIES_PREFIX + "url"))
                .orElseThrow(() -> new IllegalArgumentException("Aurora Database URL Must Not Be Null"));

        String username = Optional.ofNullable(environment.getProperty(CONFIG_PROPERTIES_PREFIX + "username"))
                .orElseThrow(() -> new IllegalArgumentException("Aurora Database Username Must Not Be Null"));

        String password = Optional.ofNullable(environment.getProperty(CONFIG_PROPERTIES_PREFIX + "password"))
                .orElseThrow(() -> new IllegalArgumentException("Aurora Database Password Must Not Be Null"));

        return ConnectionFactoryBuilder
                .withUrl(url)
                .username(username)
                .password(password)
                .build();
    }
}
