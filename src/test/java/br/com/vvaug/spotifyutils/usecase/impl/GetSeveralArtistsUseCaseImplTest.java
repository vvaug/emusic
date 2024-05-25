package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetSeveralArtistsGatewayImpl;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
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
class GetSeveralArtistsUseCaseImplTest {

    @InjectMocks
    private GetSeveralArtistsUseCaseImpl getSeveralArtistsUseCase;
    @Mock
    private GetSeveralArtistsGatewayImpl getSeveralArtistsGateway;

    @Test
    void executeTest() {
        //TODO object data
        SeveralArtistsResponse expected = SeveralArtistsResponse.builder().build();
        when(getSeveralArtistsGateway.getArtists(anyString(), anyString())).thenReturn(expected);
        SeveralArtistsResponse response = getSeveralArtistsUseCase.execute(ID, AUTHORIZATION);
        verify(getSeveralArtistsGateway, atLeastOnce()).getArtists(anyString(), anyString());
        assertEquals(expected, response);
    }
}