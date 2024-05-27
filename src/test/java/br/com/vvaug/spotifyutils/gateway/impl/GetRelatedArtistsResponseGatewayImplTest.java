package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
import br.com.vvaug.spotifyutils.response.RelatedArtistsResponse;
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
public class GetRelatedArtistsResponseGatewayImplTest {

    @InjectMocks
    private GetRelatedArtistsGatewayImpl getRelatedArtistsGateway;
    @Mock
    private SpotifyArtistClient spotifyArtistClient;

    @Test
    public void getRelatedArtistsTest() {
        RelatedArtistsResponse expected = ResponseBuilder.buildArtistsRelated();
        when(spotifyArtistClient.getRelatedArtists(any(), any())).thenReturn(expected);
        RelatedArtistsResponse response = getRelatedArtistsGateway.getRelatedArtists(ID, AUTHORIZATION);
        verify(spotifyArtistClient, atLeastOnce()).getRelatedArtists(any(), any());
        assertEquals(expected, response);

    }
}
