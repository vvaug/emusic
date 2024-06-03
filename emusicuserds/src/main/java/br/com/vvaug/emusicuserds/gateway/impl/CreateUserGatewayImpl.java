package br.com.vvaug.emusicuserds.gateway.impl;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.gateway.CreateUserGateway;
import br.com.vvaug.emusicuserds.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserGatewayImpl implements CreateUserGateway {
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        log.info("Persisting on database user: {}", user.toString());
        return userRepository.save(user);
    }
}
