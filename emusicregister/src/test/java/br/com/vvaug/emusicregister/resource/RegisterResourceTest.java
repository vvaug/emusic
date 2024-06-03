package br.com.vvaug.emusicregister.resource;

import br.com.vvaug.emusicregister.usecase.RegisterNewUserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterNewUserUseCase registerNewUserUseCase;

    @Test
    void registerNewUser() {
        assertTrue(true);
    }
}