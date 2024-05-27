package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.*;
import br.com.vvaug.spotifyutils.usecase.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
 class ArtistsResourceTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetArtistUseCase getArtistUseCase;
    @MockBean
    private GetSeveralArtistsUseCase getSeveralArtistsUseCase;

    @MockBean
    private GetArtistTopTracksUseCase getArtistTopTracksUseCase;

    @MockBean
    private GetArtistAlbumUseCase getArtistAlbumUseCase;
    @MockBean
    private GetRelatedArtistsUseCase getRelatedArtistsUseCase;

    @Test
     void getArtistTest() throws Exception {
        ArtistResponse response = ResponseBuilder.buildArtistResponse();
        when(getArtistUseCase.execute(anyString(), anyString())).thenReturn(response);
        mockMvc.perform(get("/artists/123")
                        .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION)
                .contentType(APPLICATION_JSON))
                .andExpect(status().is(OK.value()));
    }

    @Test
     void getArtistsTest() throws Exception {
        SeveralArtistsResponse severalArtistsResponse = ResponseBuilder.buildArtistsResponse();
        when(getSeveralArtistsUseCase.execute(anyString(), anyString())).thenReturn(severalArtistsResponse);
        mockMvc.perform(get("/artists")
                        .queryParam("ids", "49Wb8WyRUtoyKKO01HkRzI")
                        .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is(OK.value()));
    }

    @Test
     void getAlbumsTest() throws Exception {
        ArtistAlbumResponse albumResponse = ResponseBuilder.buildArtistsAlbumResponse();
        when(getArtistAlbumUseCase.execute(anyString(), anyString())).thenReturn(albumResponse);
        mockMvc.perform(get("/artists/49Wb8WyRUtoyKKO01HkRzI/albums")
                        .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is(OK.value()));
    }

    @Test
     void getTopTracksTest() throws Exception {
        ArtistTopTracksResponse artistTopTracksResponse = ResponseBuilder.buildArtistsTopTracksResponse();
        when(getArtistTopTracksUseCase.execute(anyString(), anyString())).thenReturn(artistTopTracksResponse);
        mockMvc.perform(get("/artists/49Wb8WyRUtoyKKO01HkRzI/top-tracks")
                        .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is(OK.value()));
    }

    @Test
     void getRelatedArtistsTest() throws Exception {
        RelatedArtistsResponse relatedArtistsResponse = ResponseBuilder.buildArtistsRelated();
        when(getRelatedArtistsUseCase.execute(anyString(), anyString())).thenReturn(relatedArtistsResponse);
        mockMvc.perform(get("/artists/49Wb8WyRUtoyKKO01HkRzI/related-artists")
                        .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is(OK.value()));

    }
}
