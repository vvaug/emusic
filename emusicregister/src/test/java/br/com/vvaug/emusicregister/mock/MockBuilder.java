package br.com.vvaug.emusicregister.mock;

import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class MockBuilder {

    public static UserResponse buildUserResponse(){
        return UserResponse.builder()
                .firstName("Administrator")
                .lastName("ADM")
                .username("root")
                .password("root")
                .active(true)
                .premium(false)
                .createdDate(LocalDate.now())
                .documentNumber("XXXXXX")
                .build();
    }

    public static CreateUserRequest buildCreateUserRequest(){
        return CreateUserRequest.builder()
                .firstName("Administrator")
                .lastName("ADM")
                .username("root")
                .password("root")
                .documentNumber("XXXXXX")
                .build();
    }
}
