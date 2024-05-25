package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetSeveralEpisodesGatewayImpl;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class GetSeveralEpisodesUseCaseImplTest {

    @InjectMocks
    private GetSeveralEpisodesUseCaseImpl getSeveralEpisodesUseCase;
    @Mock
    private GetSeveralEpisodesGatewayImpl getSeveralEpisodesGateway;

    @Test
    void executeTest() {
        //TODO object data
        SeveralEpisodesResponse expected = SeveralEpisodesResponse.builder().build();
        when(getSeveralEpisodesUseCase.execute(anyString(), anyString())).thenReturn(expected);
        SeveralEpisodesResponse response = getSeveralEpisodesUseCase.execute(ID, AUTHORIZATION);
        verify(getSeveralEpisodesGateway, atLeastOnce()).getSeveralEpisodes(anyString(), anyString());
        assertEquals(expected, response);
    }
}