package br.com.vvaug.gateway;

import br.com.vvaug.entity.User;
public interface GetUserDataGateway {

    User getUserData(String username, String password);
}
