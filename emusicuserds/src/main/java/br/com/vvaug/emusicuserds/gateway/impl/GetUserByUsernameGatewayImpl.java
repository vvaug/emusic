package br.com.vvaug.emusicuserds.gateway.impl;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.exception.ApplicationException;
import br.com.vvaug.emusicuserds.gateway.GetUserByUsernameGateway;
import br.com.vvaug.emusicuserds.repository.UserRepository;
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
