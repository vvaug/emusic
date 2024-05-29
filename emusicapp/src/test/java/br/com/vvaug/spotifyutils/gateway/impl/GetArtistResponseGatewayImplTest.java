package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
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
public class GetArtistResponseGatewayImplTest {

    @InjectMocks
    private GetArtistGatewayImpl getArtistGateway;
    @Mock
    private SpotifyArtistClient spotifyArtistClient;

    @Test
    public void getArtistTest() {
        ArtistResponse expected = ResponseBuilder.buildArtistResponse();
        when(spotifyArtistClient.getArtist(any(), any())).thenReturn(expected);
        ArtistResponse response = getArtistGateway.getArtist(ID, AUTHORIZATION);
        verify(spotifyArtistClient, atLeastOnce()).getArtist(any(), any());
        assertEquals(expected, response);

    }

}
