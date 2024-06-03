package br.com.vvaug.emusicuserds.usecase.impl;

import br.com.vvaug.emusicuserds.mapper.UserToUserResponseMapper;
import br.com.vvaug.emusicuserds.response.UserResponse;
import br.com.vvaug.emusicuserds.gateway.GetUserByUsernameGateway;
import br.com.vvaug.emusicuserds.usecase.GetUserByUsernameUseCase;
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
