package br.com.alunoonline.api.security.jwt;

import br.com.alunoonline.api.model.Auth;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTService {

    private String secretKey = "secret";

    private long validityInMilliseconds = 3600000; // 1h

    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * Metodo para gerar token Jwt
     * @param authentication Autenticação do usuario.
     * @return Token
     */
    public String createToken(Authentication authentication) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        Auth auth = (Auth) authentication.getPrincipal();


        return Jwts.builder()
                .setSubject(auth.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
    public String createTokenForResetPassword() {

        return Jwts.builder()
                .setSubject("passwordReset")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

}