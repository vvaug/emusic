package br.com.vvaug.auth.gateway.impl;

import br.com.vvaug.auth.client.EmusicUserDsClient;
import br.com.vvaug.auth.gateway.GetUserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserGatewayImpl implements GetUserGateway {
    private final EmusicUserDsClient emusicUserDsClient;
    @Override
    public UserDetails getUser(String username) {
        return emusicUserDsClient.getUser(username);
    }
}
