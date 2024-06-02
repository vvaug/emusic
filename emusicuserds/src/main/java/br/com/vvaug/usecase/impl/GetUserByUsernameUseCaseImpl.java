package br.com.vvaug.usecase.impl;

import br.com.vvaug.gateway.GetUserByUsernameGateway;
import br.com.vvaug.mapper.UserToUserResponseMapper;
import br.com.vvaug.response.UserResponse;
import br.com.vvaug.usecase.GetUserByUsernameUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserByUsernameUseCaseImpl implements GetUserByUsernameUseCase {
    private final GetUserByUsernameGateway getUserByUsernameGateway;
    @Override
    public UserResponse execute(String username) {
        return UserToUserResponseMapper.map(getUserByUsernameGateway.getUser(username));
    }
}
