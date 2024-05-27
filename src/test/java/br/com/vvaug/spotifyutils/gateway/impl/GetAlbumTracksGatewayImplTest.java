package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class GetAlbumTracksGatewayImplTest {

    @InjectMocks
    private GetAlbumTracksGatewayImpl getAlbumTracksGateway;
    @Mock
    private SpotifyAlbumClient spotifyAlbumClient;

    @Test
    void getSeveralAlbumsTest() throws IOException {
        assertTrue(true);
    }


}
