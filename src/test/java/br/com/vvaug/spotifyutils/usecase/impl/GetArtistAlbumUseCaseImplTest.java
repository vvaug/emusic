package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetArtistAlbumGatewayImpl;
import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;
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
class GetArtistAlbumUseCaseImplTest {

    @InjectMocks
    private GetArtistAlbumUseCaseImpl getArtistAlbumUseCase;
    @Mock
    private GetArtistAlbumGatewayImpl getArtistAlbumGateway;

    @Test
    void executeTest() {
        //TODO object data
        ArtistAlbumResponse expected = ArtistAlbumResponse.builder().build();
        when(getArtistAlbumGateway.getArtistAlbum(anyString(), anyString())).thenReturn(expected);
        ArtistAlbumResponse response = getArtistAlbumUseCase.execute(ID, AUTHORIZATION);
        verify(getArtistAlbumGateway, atLeastOnce()).getArtistAlbum(anyString(), anyString());
        assertEquals(expected, response);
    }
}