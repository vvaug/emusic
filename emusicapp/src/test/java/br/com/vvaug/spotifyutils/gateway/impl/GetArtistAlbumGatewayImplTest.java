package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;
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
public class GetArtistAlbumGatewayImplTest {

    @InjectMocks
    private GetArtistAlbumGatewayImpl getArtistAlbumGateway;
    @Mock
    private SpotifyArtistClient spotifyArtistClient;

    @Test
    public void getArtistAlbumTest() {
        ArtistAlbumResponse expected = ResponseBuilder.buildArtistsAlbumResponse();
        when(spotifyArtistClient.getAlbums(any(), any())).thenReturn(expected);
        ArtistAlbumResponse response = getArtistAlbumGateway.getArtistAlbum(ID, AUTHORIZATION);
        verify(spotifyArtistClient, atLeastOnce()).getAlbums(any(), any());
        assertEquals(expected, response);

    }


}
