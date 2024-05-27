package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
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
public class GetSeveralCategoriesResponseGatewayImplTest {

    @InjectMocks
    private GetSeveralCategoriesGatewayImpl getSeveralCategoriesGateway;
    @Mock
    private SpotifyCategoriesClient spotifyCategoriesClient;

    @Test
    public void getCategoriesTest() {
        SeveralCategoriesResponse expected = ResponseBuilder.buildSeveralCategories();
        when(spotifyCategoriesClient.getCategories( any())).thenReturn(expected);
        SeveralCategoriesResponse response = getSeveralCategoriesGateway.getCategories(AUTHORIZATION);
        verify(spotifyCategoriesClient, atLeastOnce()).getCategories(any());
        assertEquals(expected, response);

    }

}
