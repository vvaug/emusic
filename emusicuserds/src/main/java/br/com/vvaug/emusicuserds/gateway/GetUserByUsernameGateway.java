package br.com.vvaug.emusicuserds.gateway;

import br.com.vvaug.emusicuserds.entity.User;

public interface GetUserByUsernameGateway {

    User getUser(String username);
}
