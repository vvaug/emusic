package br.com.vvaug.resource;

import br.com.vvaug.mapper.CreateUserRequestToUserMapper;
import br.com.vvaug.mapper.UserToUserResponseMapper;
import br.com.vvaug.request.CreateUserRequest;
import br.com.vvaug.request.GetUserDataRequest;
import br.com.vvaug.response.UserResponse;
import br.com.vvaug.usecase.GetUserByUsernameUseCase;
import br.com.vvaug.usecase.impl.CreateUserUseCaseImpl;
import br.com.vvaug.usecase.impl.GetUserDataUseCaseImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetUserDataUseCaseImpl getUserDataUseCase;
    @MockBean
    private CreateUserUseCaseImpl createUserUseCase;
    @MockBean
    private GetUserByUsernameUseCase getUserByUsernameUseCase;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getUserData() throws Exception {
        GetUserDataRequest request =
                GetUserDataRequest.builder()
                        .userAuthenticationInfoBase64("dnZhdWcsdnZhdWc=")
                        .build();
        String body = objectMapper.writeValueAsString(request);
        UserResponse userResponse = UserResponse.builder().build();
        ResponseEntity<UserResponse> expected = ResponseEntity.of(Optional.of(userResponse));
        when(getUserDataUseCase.execute(any())).thenReturn(expected);
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getUserByUsername() throws Exception {
        UserResponse userResponse = UserResponse.builder().build();
        when(getUserByUsernameUseCase.execute(any())).thenReturn(userResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/root")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void createUser() throws Exception {
        CreateUserRequest request =
                CreateUserRequest.builder()
                        .username("root")
                        .password("password")
                        .firstName("Admin")
                        .lastName("Admin")
                        .documentNumber("XXXXX")
                        .build();
        String body = objectMapper.writeValueAsString(request);
        UserResponse userResponse = UserToUserResponseMapper.map(CreateUserRequestToUserMapper.map(request));
        ResponseEntity<UserResponse> expected = ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        when(createUserUseCase.execute(any())).thenReturn(expected);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(jsonPath("$.firstName", is(userResponse.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(userResponse.getLastName())));
    }

}