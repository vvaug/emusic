package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
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
public class GetArtistTopTracksResponseGatewayImplTest {

    @InjectMocks
    private GetArtistTopTracksGatewayImpl getArtistTopTracksGateway;
    @Mock
    private SpotifyArtistClient spotifyArtistClient;

    @Test
    public void getArtistTopTracksTest() {
        ArtistTopTracksResponse expected = ResponseBuilder.buildArtistsTopTracksResponse();
        when(spotifyArtistClient.getArtistTopTracks(any(), any())).thenReturn(expected);
        ArtistTopTracksResponse response = getArtistTopTracksGateway.getArtistTopTracks(ID, AUTHORIZATION);
        verify(spotifyArtistClient, atLeastOnce()).getArtistTopTracks(any(), any());
        assertEquals(expected, response);

    }

}
