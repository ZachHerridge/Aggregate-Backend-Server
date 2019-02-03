package com.mhack.aggregate.server.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.mhack.aggregate.server.api.user.domain.User;

public class JwtUtil {

    private static Algorithm algorithm = Algorithm.HMAC256("asdlkjasldkjaslkdjalsdjalskdjalskdja123");

    public static String decodeToId(String jwt) {
        try {
            if (jwt == null || jwt.trim().isEmpty()) return null;
            String userId = JWT.decode(jwt).getClaim("userId").asString();
            if (userId == null || userId.trim().isEmpty()) return null;
            return userId;
        } catch (Throwable e){
            return null;
        }
    }

    public static String create(User user) {
        try {
            return JWT.create()
                    .withIssuer("aggregate")
                    .withClaim("userId", user.getKey())
                    .withClaim("displayName", user.getDisplayName())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
