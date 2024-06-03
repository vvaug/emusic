package br.com.vvaug.auth.resource;

import br.com.vvaug.auth.mock.MockBuilder;
import br.com.vvaug.auth.request.AuthRequest;
import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.usecase.AuthenticationUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class AuthResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationUseCase authenticationUseCase;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void auth() throws Exception {
        AuthRequest request = AuthRequest.builder()
                .username("root")
                .password("root")
                .build();
        AuthResponse expected = MockBuilder.buildAuthResponse();
        when(authenticationUseCase.execute(any())).thenReturn(expected);
        mockMvc.perform(MockMvcRequestBuilders.post("/auth")
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer "+ UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.access_token", is(expected.getAccessToken())))
                        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
        verify(authenticationUseCase, atLeastOnce()).execute(any());
    }
    @Test
    void authWithAuthorizationTokenWithoutBearer() throws Exception {
        AuthRequest request = AuthRequest.builder()
                .username("root")
                .password("root")
                .build();
        AuthResponse expected = MockBuilder.buildAuthResponse();
        when(authenticationUseCase.execute(any())).thenReturn(expected);
        mockMvc.perform(MockMvcRequestBuilders.post("/auth")
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.access_token", is(expected.getAccessToken())))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
        verify(authenticationUseCase, atLeastOnce()).execute(any());
    }
    @Test
    void authWithoutAuthorizationToken() throws Exception {
        AuthRequest request = AuthRequest.builder()
                .username("root")
                .password("root")
                .build();
        AuthResponse expected = MockBuilder.buildAuthResponse();
        when(authenticationUseCase.execute(any())).thenReturn(expected);
        mockMvc.perform(MockMvcRequestBuilders.post("/auth")
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.access_token", is(expected.getAccessToken())))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
        verify(authenticationUseCase, atLeastOnce()).execute(any());
    }
}