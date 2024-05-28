package br.com.vvaug.resource;

import br.com.vvaug.request.GetUserDataRequest;
import br.com.vvaug.response.UserResponse;
import br.com.vvaug.usecase.impl.GetUserDataUseCaseImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetUserDataUseCaseImpl getUserDataUseCase;
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
}