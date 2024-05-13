package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistUseCase;
import br.com.vvaug.spotifyutils.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class ArtistsResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetArtistUseCase getArtistUseCase;


    @Test
    public void getArtist() throws Exception {

        ArtistResponse response = ArtistResponse.builder().build();

        when(getArtistUseCase.execute(anyString(), anyString())).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/artists/123")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
