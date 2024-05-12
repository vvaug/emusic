package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistsResource {

    private final GetArtistUseCase getArtistsUseCase;
    @GetMapping("/{id}")
    public ArtistResponse getArtist (@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
            return getArtistsUseCase.execute(id, authorization);
    }
}
