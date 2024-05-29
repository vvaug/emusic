package br.com.vvaug.gateway.impl;

import br.com.vvaug.entity.User;
import br.com.vvaug.exception.ApplicationException;
import br.com.vvaug.gateway.GetUserDataGateway;
import br.com.vvaug.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserDataGatewayImpl implements GetUserDataGateway {

    private final UserRepository userRepository;

    @Override
    public User getUserData(String username, String password){
        return userRepository.findUserByUsernameAndPassword(username, password)
                .orElseThrow(() -> new ApplicationException(HttpStatus.FORBIDDEN, "Can't find User. Check credentials"));
    }
}
