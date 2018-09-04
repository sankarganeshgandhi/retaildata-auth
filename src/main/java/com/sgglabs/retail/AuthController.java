package com.sgglabs.retail;

import com.sgglabs.retail.model.AuthRequest;
import com.sgglabs.retail.model.AuthSession;
import com.sgglabs.retail.model.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private static final int STATUS_INACTIVE = 1;
    private static final int STATUS_ACTIVE = 2;

    @Autowired(required = true)
    private AuthSessionRepository authRepository;

    private RestTemplate restAPITemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        this.restAPITemplate = builder.build();
        return this.restAPITemplate;
    }

    @PostMapping("{userName}/login")
    public ResponseEntity<?> loginUser(@PathVariable String userName, @RequestBody AuthRequest authRequest) {
        UserDTO user = restAPITemplate.getForObject("http://localhost:9090/users/" + userName, UserDTO.class);
        if (user != null) {
            if (user.getPassword().equalsIgnoreCase(authRequest.getPassword())) {
                AuthSession authSession = createAuthSession(user);
                authRepository.save(authSession);
                return new ResponseEntity<>(authSession, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(userName, HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{userName}/logout")
    public ResponseEntity<?> logoutUser(@PathVariable String userName, @RequestBody AuthRequest authRequest) {
        AuthSession authSession = authRepository.findByUserName(userName);
        if (authSession != null) {
            if (authSession.getStatusId() == STATUS_ACTIVE) {
                authSession.setLogoutTime(LocalDate.now());
                authSession.setModifiedDate(LocalDate.now());
                authSession.setStatusId(STATUS_INACTIVE);
                authRepository.save(authSession);
                return new ResponseEntity<>(authSession, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(userName, HttpStatus.BAD_REQUEST);
    }

    private AuthSession createAuthSession(final UserDTO user) {
        AuthSession authSession = new AuthSession();
        authSession.setUserId(user.getId());
        authSession.setUserName(user.getUserName());
        authSession.setSessionId(UUID.randomUUID().toString());
        authSession.setLoginTime(LocalDate.now());
        authSession.setCreatedDate(LocalDate.now());
        authSession.setModifiedDate(LocalDate.now());
        authSession.setStatusId(2);

        return authSession;
    }
}