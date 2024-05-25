package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.response.AlbumResponse;
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
class GetAlbumGatewayImplTest {

    @InjectMocks
    private GetAlbumGatewayImpl getAlbumGateway;
    @Mock
    private SpotifyAlbumClient spotifyAlbumClient;

    @Test
    public void getAlbumTest(){
        //TODO object data
        AlbumResponse expected = AlbumResponse.builder().build();
        when(spotifyAlbumClient.getAlbum(any(), any())).thenReturn(expected);
        AlbumResponse response = getAlbumGateway.getAlbum(ID, AUTHORIZATION);
        verify(spotifyAlbumClient, atLeastOnce()).getAlbum(any(), any());
        assertEquals(expected, response);
    }
}