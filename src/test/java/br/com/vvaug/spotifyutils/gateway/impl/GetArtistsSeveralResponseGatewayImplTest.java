package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
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
public class GetArtistsSeveralResponseGatewayImplTest {

    @InjectMocks
    private GetSeveralArtistsGatewayImpl getSeveralArtistsGateway;
    @Mock
    private SpotifyArtistClient spotifyArtistClient;

    @Test
    public void getArtistsTest() {
        SeveralArtistsResponse expected = ResponseBuilder.buildArtistsResponse();
        when(spotifyArtistClient.getArtists(any(), any())).thenReturn(expected);
        SeveralArtistsResponse response = getSeveralArtistsGateway.getArtists(ID, AUTHORIZATION);
        verify(spotifyArtistClient, atLeastOnce()).getArtists(any(), any());
        assertEquals(expected, response);

    }

}
