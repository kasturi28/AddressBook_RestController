package com.bridgelabz.addressbook.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtToken {

    private static final String SECRET="Kasturi";

    public String createToken(int userId)
    {
        String token= JWT.create().withClaim("id",userId).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public int decodeJWT(String jwt)
    {
        int id=0;
        if(jwt!=null)
        {

            id=JWT.require(Algorithm.HMAC256(SECRET)).build().verify(jwt).getClaim("id").asInt();
        }
        return id;
    }
}


