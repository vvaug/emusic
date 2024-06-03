package br.com.vvaug.auth.mock;

import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.response.UserResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.UUID;

@UtilityClass
public class MockBuilder {

    public AuthResponse buildAuthResponse(){
        return AuthResponse.builder()
                .accessToken(UUID.randomUUID().toString())
                .build();
    }

    public UserResponse buildUserResponse(){
        return UserResponse.builder()
                .active(false)
                .createdDate(LocalDate.now())
                .documentNumber("XXXXXX")
                .firstName("Adm")
                .lastName("Adm")
                .username("root")
                .password("root")
                .premium(false)
                .build();
    }
}
