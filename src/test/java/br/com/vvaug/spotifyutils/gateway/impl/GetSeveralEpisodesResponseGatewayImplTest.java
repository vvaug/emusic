package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.client.SpotifyEpisodeClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;
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
public class GetSeveralEpisodesResponseGatewayImplTest {

    @InjectMocks
    private GetSeveralEpisodesGatewayImpl getSeveralEpisodesGateway;
    @Mock
    private SpotifyEpisodeClient spotifyEpisodeClient;

    @Test
    public void getSeveralEpisodesTest() {
        SeveralEpisodesResponse expected = ResponseBuilder.buildEpisodeSeveralResponse();
        when(spotifyEpisodeClient.getSeveralEpisodes(any(), any())).thenReturn(expected);
        SeveralEpisodesResponse response = getSeveralEpisodesGateway.getSeveralEpisodes(ID,AUTHORIZATION);
        verify(spotifyEpisodeClient, atLeastOnce()).getSeveralEpisodes(any(),any());
        assertEquals(expected, response);

    }

}
