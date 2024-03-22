package com.spring.learnspringsecurity.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder;

    @GetMapping("/authenticate")
    public JwtResponse authentication(Authentication authentication)
    {
            return new JwtResponse("token");
    }

    private String createToken(Authentication authentication)
    {
        var claim=JwtClaimsSet.builder().issuer("self").issuedAt(Instant.now()).expiresAt(Instant.now().plusSeconds(60*15))
                .subject(authentication.getName()).claim("scope",createScope(authentication)).build();
        JwtEncoderParameters parameters=JwtEncoderParameters.from(claim);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Authentication authentication) {
       return authentication.getAuthorities().stream().map(a ->a.getAuthority()).collect(Collectors.joining(" "));
    }
}

record JwtResponse(String token){}
