package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import br.com.vvaug.spotifyutils.usecase.GetAlbumTracksUseCase;
import br.com.vvaug.spotifyutils.usecase.GetAlbumUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralAlbumsUseCase;
import br.com.vvaug.spotifyutils.utils.TestUtils;
import org.apache.http.HttpHeaders;
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

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class AlbumsResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetAlbumUseCase getAlbumUseCase;
    @MockBean
    private GetSeveralAlbumsUseCase getSeveralAlbumsUseCase;
    @MockBean
    private GetAlbumTracksUseCase getAlbumTracksUseCase;

    @Test
    void getAlbumTest() throws Exception {
        //TODO object data
        AlbumResponse albumResponse = AlbumResponse.builder().build();
        when(getAlbumUseCase.execute(anyString(), anyString())).thenReturn(albumResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/albums/49Wb8WyRUtoyKKO01HkRzI")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void getSeveralAlbumsTest() throws Exception {
        //TODO
        SeveralAlbumsResponse severalAlbumResponse = SeveralAlbumsResponse.builder().build();
        when(getSeveralAlbumsUseCase.execute(anyString(), anyString())).thenReturn(severalAlbumResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/albums")
                        .queryParam("ids", "49Wb8WyRUtoyKKO01HkRzI")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void getAlbumTracksTest() throws Exception {
        AlbumTracksResponse albumTracksResponse = AlbumTracksResponse.builder().build();
        when(getAlbumTracksUseCase.execute(anyString(), anyString())).thenReturn(albumTracksResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/albums/49Wb8WyRUtoyKKO01HkRzI/tracks")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}