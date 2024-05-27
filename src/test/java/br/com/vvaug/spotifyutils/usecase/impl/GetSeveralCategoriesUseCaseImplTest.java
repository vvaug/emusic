package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetSeveralCategoriesGatewayImpl;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
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
class GetSeveralCategoriesUseCaseImplTest {

    @InjectMocks
    private GetSeveralCategoriesUseCaseImpl getSeveralCategoriesUseCase;
    @Mock
    private GetSeveralCategoriesGatewayImpl getSeveralCategoriesGateway;

    @Test
    void executeTest(){
        SeveralCategoriesResponse expected = ResponseBuilder.buildSeveralCategories();
        when(getSeveralCategoriesGateway.getCategories(anyString())).thenReturn(expected);
        SeveralCategoriesResponse response = getSeveralCategoriesUseCase.execute(AUTHORIZATION);
        verify(getSeveralCategoriesGateway, atLeastOnce()).getCategories(anyString());
        assertEquals(expected, response);
    }
}