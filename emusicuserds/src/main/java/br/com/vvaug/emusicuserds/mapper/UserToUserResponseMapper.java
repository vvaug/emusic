package br.com.vvaug.emusicuserds.mapper;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.response.UserResponse;
import lombok.experimental.UtilityClass;

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
