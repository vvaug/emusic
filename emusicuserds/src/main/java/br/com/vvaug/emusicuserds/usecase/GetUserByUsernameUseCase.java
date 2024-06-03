package br.com.vvaug.emusicuserds.usecase;

import br.com.vvaug.emusicuserds.response.UserResponse;

public interface GetUserByUsernameUseCase {

    UserResponse execute(String username);
}
