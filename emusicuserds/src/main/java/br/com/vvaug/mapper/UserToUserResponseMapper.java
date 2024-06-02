package br.com.vvaug.mapper;

import br.com.vvaug.entity.User;
import br.com.vvaug.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserToUserResponseMapper {

    public static UserResponse map (User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .active(user.isActive())
                .createdDate(user.getCreatedDate())
                .documentNumber(user.getDocumentNumber())
                .lastName(user.getLastName())
                .premium(user.isPremium())
                .firstName(user.getFirstName())
                .build();
    }
}
