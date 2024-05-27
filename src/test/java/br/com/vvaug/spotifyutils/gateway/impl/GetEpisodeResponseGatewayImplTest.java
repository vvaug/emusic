package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.client.SpotifyEpisodeClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.response.EpisodeResponse;
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
public class GetEpisodeResponseGatewayImplTest {

    @InjectMocks
    private GetEpisodeGatewayImpl getEpisodeGateway;
    @Mock
    private SpotifyEpisodeClient spotifyEpisodeClient;

    @Test
    public void getEpisodeTest() {
        EpisodeResponse expected = ResponseBuilder.buildEpisodeResponse();
        when(spotifyEpisodeClient.getEpisode(any(), any())).thenReturn(expected);
        EpisodeResponse response = getEpisodeGateway.getEpisode(ID,AUTHORIZATION);
        verify(spotifyEpisodeClient, atLeastOnce()).getEpisode(any(),any());
        assertEquals(expected, response);

    }


}
