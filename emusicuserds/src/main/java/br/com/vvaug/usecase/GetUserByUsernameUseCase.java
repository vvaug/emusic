package br.com.vvaug.usecase;

import br.com.vvaug.response.UserResponse;

public interface GetUserByUsernameUseCase {

    UserResponse execute(String username);
}
