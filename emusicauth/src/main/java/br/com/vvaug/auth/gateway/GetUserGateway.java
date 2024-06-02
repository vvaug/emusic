package br.com.vvaug.auth.gateway;

import org.springframework.security.core.userdetails.UserDetails;

public interface GetUserGateway {

    UserDetails getUser(String username);
}
