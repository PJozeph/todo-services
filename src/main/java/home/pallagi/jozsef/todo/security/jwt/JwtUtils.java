package home.pallagi.jozsef.todo.security.jwt;

import home.pallagi.jozsef.todo.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
    }


    public String getUserNameFromJwtToken(String token) {
        Jwe<Claims> jwe = Jwts.parser()
                .decryptWith(key())
                .build()
                .parseEncryptedClaims(token);
        return jwe.getPayload().getSubject();
    }

    private SecretKey key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .decryptWith(key())
                    .build()
                    .parseEncryptedClaims(authToken);
            return true;
        } catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
//            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
//            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
