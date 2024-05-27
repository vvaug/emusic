package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetAlbumSeveralAlbumsGatewayImplTest {

    @InjectMocks
    private GetSeveralAlbumsGatewayImpl getSeveralAlbumsGateway;
    @Mock
    private SpotifyAlbumClient spotifyAlbumClient;

    @Test
    public void getSeveralAlbumsTest() {
        SeveralAlbumsResponse expected = ResponseBuilder.buildSeveralAlbumsResponse();
        when(spotifyAlbumClient.getSeveralAlbums(any(), any())).thenReturn(expected);
        SeveralAlbumsResponse response = getSeveralAlbumsGateway.getSeveralAlbums(ID, AUTHORIZATION);
        verify(spotifyAlbumClient, atLeastOnce()).getSeveralAlbums(any(), any());
        assertEquals(expected, response);
    }


}
