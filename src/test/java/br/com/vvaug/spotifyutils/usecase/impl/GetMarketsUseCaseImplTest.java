package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetMarketsGatewayImpl;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.MarketsResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class GetMarketsUseCaseImplTest {

    @InjectMocks
    private GetMarketsUseCaseImpl getMarketsUseCase;
    @Mock
    private GetMarketsGatewayImpl getMarketsGateway;

    @Test
    void executeTest() throws IOException {
        MarketsResponse expected = ResponseBuilder.buildMarketsResponse();
        when(getMarketsGateway.getMarkets(anyString())).thenReturn(expected);
        MarketsResponse response = getMarketsUseCase.execute(AUTHORIZATION);
        verify(getMarketsGateway, atLeastOnce()).getMarkets(anyString());
        assertEquals(expected, response);
    }
}