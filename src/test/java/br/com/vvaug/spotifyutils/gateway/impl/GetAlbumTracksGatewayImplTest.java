package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
public class GetAlbumTracksGatewayImplTest {

    @InjectMocks
    private GetAlbumTracksGatewayImpl getAlbumTracksGateway;
    @Mock
    private SpotifyAlbumClient spotifyAlbumClient;

    @Test
    public void getSeveralAlbumsTest() throws IOException {

    }


}
