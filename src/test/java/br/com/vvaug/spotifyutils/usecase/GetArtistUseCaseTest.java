package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.gateway.GetArtistGateway;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.usecase.impl.GetArtistUseCaseImpl;
import br.com.vvaug.spotifyutils.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GetArtistUseCaseTest {

    @InjectMocks
    GetArtistUseCaseImpl getArtistUseCase;
    @Mock
    private GetArtistGateway getArtistGateway;

    @Test
    public void execute (){
        ArtistResponse artistResponse = ArtistResponse.builder().build();
        when(getArtistGateway.getArtist(anyString(), anyString())).thenReturn(artistResponse);
        getArtistUseCase.execute("id", TestUtils.AUTHORIZATION);
    }
}
