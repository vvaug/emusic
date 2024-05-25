package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetAlbumTracksGatewayImpl;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class GetAlbumTracksUseCaseImplTest {

    @InjectMocks
    private GetAlbumTracksUseCaseImpl getAlbumTracksUseCase;
    @Mock
    private GetAlbumTracksGatewayImpl getAlbumTracksGateway;

    @Test
    void executeTest() {
        //TODO object data
        AlbumTracksResponse expected = AlbumTracksResponse.builder().build();
        when(getAlbumTracksGateway.getAlbumTracks(anyString(),anyString())).thenReturn(expected);
        AlbumTracksResponse response = getAlbumTracksUseCase.execute(TestUtils.ID, TestUtils.AUTHORIZATION);
        verify(getAlbumTracksGateway, atLeastOnce()).getAlbumTracks(anyString(), anyString());
        assertEquals(expected, response);
    }
}
