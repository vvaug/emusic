package br.com.vvaug.emusicuserds.usecase.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.mapper.CreateUserRequestToUserMapper;
import br.com.vvaug.emusicuserds.mapper.UserToUserResponseMapper;
import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import br.com.vvaug.emusicuserds.response.UserResponse;
import br.com.vvaug.emusicuserds.usecase.CreateUserUseCase;
import br.com.vvaug.emusicuserds.gateway.CreateUserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;

    @Override
    public ResponseEntity<UserResponse> execute(CreateUserRequest createUserRequest) {
        User user = CreateUserRequestToUserMapper.map(createUserRequest);
        String userPasswordEncoded = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(userPasswordEncoded);
        setProperties(user);
        createUserGateway.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                            .body(UserToUserResponseMapper.map(createUserGateway.createUser(user)
                            ));
    }

    private void setProperties(User user) {
        user.setCreatedDate(LocalDate.now());
        user.setPremium(false);
        user.setQuantityFollowers(0);
        user.setQuantityFollowing(0);
    }
}
