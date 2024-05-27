package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetArtistTopTracksGatewayImpl;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
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
class GetArtistTopTracksUseCaseImplTest {

    @InjectMocks
    private GetArtistTopTracksUseCaseImpl getArtistTopTracksUseCase;
    @Mock
    private GetArtistTopTracksGatewayImpl getArtistTopTracksGateway;

    @Test
    void executeTest(){
        ArtistTopTracksResponse expected = ResponseBuilder.buildArtistsTopTracksResponse();
        when(getArtistTopTracksGateway.getArtistTopTracks(anyString(), anyString())).thenReturn(expected);
        ArtistTopTracksResponse response = getArtistTopTracksUseCase.execute(ID, AUTHORIZATION);
        verify(getArtistTopTracksGateway, atLeastOnce()).getArtistTopTracks(anyString(), anyString());
        assertEquals(expected, response);
    }
}