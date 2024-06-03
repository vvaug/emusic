package br.com.vvaug.emusicuserds.mapper;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.mock.MockBuilder;
import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserRequestToUserMapperTest {

    @Test
    void map(){
        CreateUserRequest createUserRequest = MockBuilder.buildCreateUserRequest();
        User user = CreateUserRequestToUserMapper.map(createUserRequest);
        assertNotNull(user);
        assertEquals(createUserRequest.getUsername(), user.getUsername());
        assertEquals(createUserRequest.getPassword(), user.getPassword());
    }
}