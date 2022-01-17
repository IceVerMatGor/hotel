package by.gorbov.hotel.config.jwt;

import by.gorbov.hotel.config.JwtConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import io.jsonwebtoken.security.Keys;


@Configuration
public class SecretKey {

    private final JwtConfig jwtConfig;

    public SecretKey(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }


    @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
    }
}
