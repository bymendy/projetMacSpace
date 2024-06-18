package com.macsecurite.macsecurite.manager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Calendar;

/**
 * Gestionnaire de jetons JWT pour l'authentification et l'autorisation.
 */
public class JwtTokenManager {

    /**
     * Génère un jeton JWT pour un utilisateur donné.
     *
     * @param tokenUser l'utilisateur pour lequel le jeton est généré.
     * @return le jeton JWT généré.
     */
    public static String generateToken(String tokenUser){
        Calendar calendar = Calendar.getInstance();
        calendar .add(Calendar.HOUR, 24);
        // calendar .add(Calendar.DAY_OF_MONTH, 30);


        return Jwts.builder()
                .subject(tokenUser)
                .expiration(calendar.getTime())
                .signWith(secretKey(), Jwts.SIG.HS256)
                .compact();
    }


    /**
     * Extrait l'utilisateur à partir d'un jeton JWT donné.
     *
     * @param token le jeton JWT à analyser.
     * @return l'utilisateur extrait du jeton.
     * @throws Exception si l'analyse du jeton échoue.
     */
    public static String getUser(String token) throws Exception {
        Claims claims = Jwts.parser().verifyWith(secretKey()).build().parseSignedClaims(token).getPayload();
        return claims.getSubject();
    }

    /**
     * Génère une clé secrète pour signer et vérifier les jetons JWT.
     *
     * @return la clé secrète.
     */
    private static SecretKey secretKey() {
        String cleCryptage = "wzUpGa9k4LTV3QHuY8qVrt6wOENkvdes5vLHVc1ex6581IiQ";
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(cleCryptage));
    }
}
