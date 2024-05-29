package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.client.SpotifyGenresClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.GenresResponse;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetGenresResponseGatewayImplTest {

    @InjectMocks
    private GetGenresGatewayImpl getGenresGateway;
    @Mock
    private SpotifyGenresClient spotifyGenresClient;

    @Test
    public void getGenresTest() {
        GenresResponse expected = ResponseBuilder.buildGenresResponse();
        when(spotifyGenresClient.getGenres( any())).thenReturn(expected);
        GenresResponse response = getGenresGateway.getGenres(AUTHORIZATION);
        verify(spotifyGenresClient, atLeastOnce()).getGenres(any());
        assertEquals(expected, response);

    }

}
