package br.com.vvaug.gateway.impl;

import br.com.vvaug.entity.User;
import br.com.vvaug.exception.ApplicationException;
import br.com.vvaug.gateway.GetUserByUsernameGateway;
import br.com.vvaug.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserByUsernameGatewayImpl implements GetUserByUsernameGateway {
    private final UserRepository userRepository;
    @Override
    public User getUser(String username) {
        log.info("Searching for user: {} on database", username);
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new ApplicationException(HttpStatus.NOT_FOUND, "User: " + username + " not found."));
    }
}
