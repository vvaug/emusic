package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetSingleCategoryGatewayImpl;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetSingleCategoryUseCaseImplTest {

    @InjectMocks
    private GetSingleCategoryUseCaseImpl getSingleCategoryUseCase;
    @Mock
    private GetSingleCategoryGatewayImpl getSingleCategoryGateway;

    @Test
    void executeTest() throws IOException {
        CategoriesItemResponse expected = ResponseBuilder.buildSingleCategory();
        when(getSingleCategoryUseCase.execute(anyString(), anyString())).thenReturn(expected);
        CategoriesItemResponse response = getSingleCategoryUseCase.execute(ID, AUTHORIZATION);
        verify(getSingleCategoryGateway, atLeastOnce()).getSingleCategory(anyString(), anyString());
        assertEquals(expected, response);
    }
}