package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetRelatedArtistsGatewayImpl;
import br.com.vvaug.spotifyutils.response.RelatedArtistsResponse;
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
class GetRelatedArtistsUseCaseImplTest {

    @InjectMocks
    private GetRelatedArtistsUseCaseImpl getRelatedArtistsUseCase;
    @Mock
    private GetRelatedArtistsGatewayImpl getRelatedArtistsGateway;

    @Test
    void executeTest() {
        //TODO object data
        RelatedArtistsResponse expected = RelatedArtistsResponse.builder().build();
        when(getRelatedArtistsGateway.getRelatedArtists(anyString(), anyString())).thenReturn(expected);
        RelatedArtistsResponse response = getRelatedArtistsUseCase.execute(ID, AUTHORIZATION);
        verify(getRelatedArtistsGateway, atLeastOnce()).getRelatedArtists(anyString(), anyString());
        assertEquals(expected, response);
    }

}