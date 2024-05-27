package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.SignInGatewayImpl;
import br.com.vvaug.spotifyutils.response.SignInResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignInUseCaseImplTest {

    @InjectMocks
    private SignInUseCaseImpl signInUseCase;
    @Mock
    private SignInGatewayImpl signInGateway;

    @Test
    void executeTest() {
        SignInResponse expected = SignInResponse.builder().access_token(AUTHORIZATION).build();
        when(signInUseCase.execute()).thenReturn(expected);
        SignInResponse response = signInUseCase.execute();
        verify(signInGateway, atLeastOnce()).execute(any(), any(), any());
        assertEquals(expected, response);
    }
}
