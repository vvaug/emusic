package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.client.SpotifyMarketsClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.MarketsResponse;
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
public class GetMarketsResponseGatewayImplTest {

    @InjectMocks
    private GetMarketsGatewayImpl getMarketsGateway;
    @Mock
    private SpotifyMarketsClient spotifyMarketsClient;

    @Test
    public void getMarketsTest() {
        MarketsResponse expected = ResponseBuilder.buildMarketsResponse();
        when(spotifyMarketsClient.getMarkets(any())).thenReturn(expected);
        MarketsResponse response = getMarketsGateway.getMarkets(AUTHORIZATION);
        verify(spotifyMarketsClient, atLeastOnce()).getMarkets(any());
        assertEquals(expected, response);
    }



}
