package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.vvaug.spotifyutils.utils.TestUtils.AUTHORIZATION;
import static br.com.vvaug.spotifyutils.utils.TestUtils.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetCategoriesItemResponseGatewayImplTest {

    @InjectMocks
    private GetSingleCategoryGatewayImpl getSingleCategoryGateway;
    @Mock
    private SpotifyCategoriesClient spotifyCategoriesClient;

    @Test
    public void getSingleCategoryTest() {
        CategoriesItemResponse expected = ResponseBuilder.buildSingleCategory();
        when(spotifyCategoriesClient.getSingleCategory(any(), any())).thenReturn(expected);
        CategoriesItemResponse response = getSingleCategoryGateway.getSingleCategory(ID,AUTHORIZATION);
        verify(spotifyCategoriesClient, atLeastOnce()).getSingleCategory(any(),any());
        assertEquals(expected, response);

    }

}
