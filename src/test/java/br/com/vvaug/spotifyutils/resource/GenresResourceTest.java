package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.GenresResponse;
import br.com.vvaug.spotifyutils.usecase.GetGenresUseCase;
import br.com.vvaug.spotifyutils.utils.TestUtils;
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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class GenresResourceTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private GetGenresUseCase getGenresUseCase;

    @Test
    void getGenreTest() throws Exception {
        GenresResponse genresResponse = GenresResponse.builder().build();
        when(getGenresUseCase.execute(anyString())).thenReturn(genresResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/available-genre-seeds")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}