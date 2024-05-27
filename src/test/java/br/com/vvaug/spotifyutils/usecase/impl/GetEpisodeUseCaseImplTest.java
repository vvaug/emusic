package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetEpisodeGatewayImpl;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.EpisodeResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class GetEpisodeUseCaseImplTest {

    @InjectMocks
    private GetEpisodeUseCaseImpl getEpisodeUseCase;

    @Mock
    private GetEpisodeGatewayImpl getEpisodeGateway;

    @Test
    void executeTest() throws IOException {
        //TODO object data
        EpisodeResponse expected = ResponseBuilder.buildEpisodeResponse();
        when(getEpisodeGateway.getEpisode(anyString(), anyString())).thenReturn(expected);
        EpisodeResponse response = getEpisodeUseCase.execute(ID, AUTHORIZATION);
        verify(getEpisodeGateway, atLeastOnce()).getEpisode(anyString(), anyString());
        assertEquals(expected, response);
    }
}