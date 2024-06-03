package br.com.vvaug.emusicuserds.mapper;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import lombok.experimental.UtilityClass;

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
