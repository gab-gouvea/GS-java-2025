package br.com.futurodotrabalho.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("LDFHJLJQL3IJQ;3K;12OP9AWIO[AJSXPIDOKFDFDFDQP2P".getBytes(StandardCharsets.UTF_8));

    public static String gerarToken(String username, String role) {
        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SECRET_KEY, Jwts.SIG.HS256)
                .compact();
    }

    public static Claims validarToken(String token) {
        JwtParser parser = Jwts.parser().verifyWith(SECRET_KEY).build();
        return parser.parseSignedClaims(token).getPayload();
    }
}
