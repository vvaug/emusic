package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetAlbumTracksResponseGatewayImplTest {

    @InjectMocks
    private GetAlbumTracksGatewayImpl getAlbumTracksGateway;
    @Mock
    private SpotifyAlbumClient spotifyAlbumClient;

    @Test
    public void getAlbumsTracksTest() {
        AlbumTracksResponse expected = ResponseBuilder.buildAlbumTracksResponse();
        when(spotifyAlbumClient.getAlbumTracks(any(), any())).thenReturn(expected);
        AlbumTracksResponse response = getAlbumTracksGateway.getAlbumTracks(ID, AUTHORIZATION);
        verify(spotifyAlbumClient, atLeastOnce()).getAlbumTracks(any(), any());
        assertEquals(expected, response);

    }
}
