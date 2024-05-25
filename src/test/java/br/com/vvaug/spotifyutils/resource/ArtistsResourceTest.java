package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistAlbumUseCase;
import br.com.vvaug.spotifyutils.usecase.GetArtistTopTracksUseCase;
import br.com.vvaug.spotifyutils.usecase.GetArtistUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralArtistsUseCase;
import br.com.vvaug.spotifyutils.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
    @MockBean
    private GetSeveralArtistsUseCase getSeveralArtistsUseCase;

    @MockBean
    private GetArtistTopTracksUseCase getArtistTopTracksUseCase;

    @MockBean
    private GetArtistAlbumUseCase getArtistAlbumUseCase;
    @Test
    public void getArtistTest() throws Exception {

        //TODO dar valores ao objeto
        ArtistResponse response = ArtistResponse.builder().build();

        when(getArtistUseCase.execute(anyString(), anyString())).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/artists/123")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    public void getArtistsTest() throws Exception {

        //TODO
        SeveralArtistsResponse severalArtistsResponse = SeveralArtistsResponse.builder().build();
        when(getSeveralArtistsUseCase.execute(anyString(), anyString())).thenReturn(severalArtistsResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/artists")
                        .queryParam("ids", "49Wb8WyRUtoyKKO01HkRzI")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));


    }

    @Test
    public void getAlbumsTest() throws Exception {

        //TODO
        ArtistAlbumResponse albumResponse = ArtistAlbumResponse.builder().build();
        when(getArtistAlbumUseCase.execute(anyString(), anyString())).thenReturn(albumResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/artists/49Wb8WyRUtoyKKO01HkRzI/albums")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));


    }

    @Test
    public void getTopTracksTest() throws Exception {

        //TODO
        ArtistTopTracksResponse artistTopTracksResponse = ArtistTopTracksResponse.builder().build();
        when(getArtistTopTracksUseCase.execute(anyString(), anyString())).thenReturn(artistTopTracksResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/artists/49Wb8WyRUtoyKKO01HkRzI/top-tracks")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));


    }
}
