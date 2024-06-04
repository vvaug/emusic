package br.com.vvaug.emusicregister.resource;

import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import br.com.vvaug.emusicregister.usecase.RegisterNewUserUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterNewUserUseCase registerNewUserUseCase;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void registerNewUser() throws Exception {
        UserResponse expected = UserResponse.builder()
                .active(false)
                .createdDate(LocalDate.now())
                .premium(false)
                .username("root")
                .password("root")
                .firstName("Administrator")
                .lastName("Adm")
                .build();
        when(registerNewUserUseCase.execute(any())).thenReturn(expected);
        CreateUserRequest request = CreateUserRequest.builder()
                .firstName("Administrator")
                .lastName("Adm")
                .username("root")
                .password("root")
                .documentNumber("XXXXXXX")
                .build();
        String requestBody = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
                .andExpect(jsonPath("$.username", is(expected.getUsername())));
    }
}