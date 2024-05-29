package br.com.vvaug.gateway;

import br.com.vvaug.entity.User;

public interface GetUserByUsernameGateway {

    User getUser(String username);
}
