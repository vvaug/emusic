package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.EpisodeResponse;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;
import br.com.vvaug.spotifyutils.usecase.GetEpisodeUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralEpisodesUseCase;
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
class EpisodeResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetEpisodeUseCase getEpisodeUseCase;
    @MockBean
    private GetSeveralEpisodesUseCase getSeveralEpisodesUseCase;

    @Test
    void getEpisodeTest() throws Exception {
        //TODO object data;
        EpisodeResponse episodeResponse = EpisodeResponse.builder().build();
        when(getEpisodeUseCase.execute(anyString(), anyString())).thenReturn(episodeResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/episodes/512ojhOuo1ktJprKbVcKyQ")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void getSeveralEpisodesTest() throws Exception {
        SeveralEpisodesResponse severalEpisodesResponse = SeveralEpisodesResponse.builder().build();
        when(getSeveralEpisodesUseCase.execute(anyString(), anyString())).thenReturn(severalEpisodesResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/episodes")
                        .queryParam("ids", "512ojhOuo1ktJprKbVcKyQ")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}