package br.com.vvaug.gateway.impl;

import br.com.vvaug.entity.User;
import br.com.vvaug.exception.ApplicationException;
import br.com.vvaug.gateway.GetUserDataGateway;
import br.com.vvaug.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserDataGatewayImpl implements GetUserDataGateway {

    private final UserRepository userRepository;

    @Override
    public User getUserData(String username, String password){
        log.info("Searching for user: {} on database...", username);
        return userRepository.findUserByUsernameAndPassword(username, password)
                .orElseThrow(() -> new ApplicationException(HttpStatus.FORBIDDEN, "Bad Credentials."));
    }
}
