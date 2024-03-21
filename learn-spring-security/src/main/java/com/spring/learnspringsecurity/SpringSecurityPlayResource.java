package com.spring.learnspringsecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityPlayResource {

    @GetMapping("/csrf-token")
    public CsrfToken retriveCsrfToken(HttpServletRequest httpServletRequest)
    {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}
