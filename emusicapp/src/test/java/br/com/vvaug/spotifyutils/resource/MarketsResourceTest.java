package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.mock.ResponseBuilder;
import br.com.vvaug.spotifyutils.response.MarketsResponse;
import br.com.vvaug.spotifyutils.usecase.GetMarketsUseCase;
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

@SpringBootTest
@AutoConfigureMockMvc
class MarketsResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetMarketsUseCase getMarketsUseCase;

    @Test
    void getMarketsTest() throws Exception {
        MarketsResponse marketsResponse = ResponseBuilder.buildMarketsResponse();
        when(getMarketsUseCase.execute(anyString())).thenReturn(marketsResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/markets")
                        .header(HttpHeaders.AUTHORIZATION, TestUtils.AUTHORIZATION)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}