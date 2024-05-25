package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetAlbumGatewayImpl;
import br.com.vvaug.spotifyutils.response.AlbumResponse;
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
class GetAlbumUseCaseImplTest {

    @InjectMocks
    private GetAlbumUseCaseImpl getAlbumUseCase;

    @Mock
    private GetAlbumGatewayImpl getAlbumGateway;

    @Test
    void executeTest() {
        //TODO object data
        AlbumResponse expected = AlbumResponse.builder().build();
        when(getAlbumGateway.getAlbum(anyString(), anyString())).thenReturn(expected);
        AlbumResponse response = getAlbumUseCase.execute(ID, AUTHORIZATION);
        verify(getAlbumGateway, atLeastOnce()).getAlbum(anyString(), anyString());
        assertEquals(expected, response);
    }
}