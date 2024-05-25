package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetGenresGatewayImpl;
import br.com.vvaug.spotifyutils.response.GenresResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class GetGenresUseCaseImplTest {

    @InjectMocks
    private GetGenresUseCaseImpl getGenresUseCase;
    @Mock
    private GetGenresGatewayImpl getGenresGateway;

    @Test
    void executeTest() {
        //TODO object data
        GenresResponse expected = GenresResponse.builder().build();
        when(getGenresGateway.getGenres(anyString())).thenReturn(expected);
        GenresResponse response = getGenresUseCase.execute(AUTHORIZATION);
        verify(getGenresGateway, atLeastOnce()).getGenres(anyString());
        assertEquals(expected, response);
    }
}