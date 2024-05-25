package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetSeveralAlbumsGatewayImpl;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
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
class GetSeveralAlbumsUseCaseImplTest {

    @InjectMocks
    private GetSeveralAlbumsUseCaseImpl getSeveralAlbumsUseCase;
    @Mock
    private GetSeveralAlbumsGatewayImpl getSeveralAlbumsGateway;

    @Test
    void executeTest() {
        //TODO object data
        SeveralAlbumsResponse expected = SeveralAlbumsResponse.builder().build();
        when(getSeveralAlbumsGateway.getSeveralAlbums(anyString(), anyString())).thenReturn(expected);
        SeveralAlbumsResponse response = getSeveralAlbumsUseCase.execute(ID, AUTHORIZATION);
        verify(getSeveralAlbumsGateway, atLeastOnce()).getSeveralAlbums(anyString(), anyString());
        assertEquals(expected, response);
    }
}