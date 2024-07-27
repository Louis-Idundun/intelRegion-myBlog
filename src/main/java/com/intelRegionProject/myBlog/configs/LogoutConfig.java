package com.intelRegionProject.myBlog.configs;

import com.intelRegionProject.myBlog.exceptions.MyBlogException;
import com.intelRegionProject.myBlog.services.implementations.JwtImplementation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class LogoutConfig implements LogoutHandler {

    private final UserDetailsService userDetailsService;
    private final JwtImplementation jwtImplementation;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }
        jwtToken = authHeader.substring(7);
        if(jwtImplementation.isTokenExpired(jwtToken)) {
            throw new MyBlogException("Your session has expired. Please login");
        }

        String email = jwtImplementation.extractUsername(jwtToken);
        if (email != null) {
            new UsernamePasswordAuthenticationToken(
                    this.userDetailsService.loadUserByUsername(email),
                    null, Collections.emptyList()
            );
        }

    }
}

