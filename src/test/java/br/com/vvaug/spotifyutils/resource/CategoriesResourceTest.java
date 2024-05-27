package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import br.com.vvaug.spotifyutils.usecase.GetSeveralCategoriesUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSingleCategoryUseCase;
import br.com.vvaug.spotifyutils.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class CategoriesResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetSeveralCategoriesUseCase getSeveralCategoriesUseCase;
    @MockBean
    private GetSingleCategoryUseCase getSingleCategoryUseCase;

    @Test
    void getCategoriesTest() throws Exception {
        SeveralCategoriesResponse severalCategoriesResponse = ResponseBuilder.buildSeveralCategories();
        when(getSeveralCategoriesUseCase.execute(anyString())).thenReturn(severalCategoriesResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/browse/categories")
                .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }

    @Test
    void getSingleCategoryTest() throws Exception {
        CategoriesItemResponse categoriesItemResponse = ResponseBuilder.buildSingleCategory();
        when(getSingleCategoryUseCase.execute(anyString(),anyString())).thenReturn(categoriesItemResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/browse/categories/dinner")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}