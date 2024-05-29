package br.com.vvaug.mapper;

import br.com.vvaug.entity.User;
import br.com.vvaug.request.CreateUserRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateUserRequestToUserMapper {

    public static User map (CreateUserRequest createUserRequest){
        return User.builder()
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .documentNumber(createUserRequest.getDocumentNumber())
                .build();
    }
}
