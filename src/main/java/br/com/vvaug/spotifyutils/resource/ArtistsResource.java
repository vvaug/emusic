package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistAlbumUseCase;
import br.com.vvaug.spotifyutils.usecase.GetArtistUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralArtistsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistsResource {

    private final GetArtistUseCase getArtistUseCase;
    private final GetSeveralArtistsUseCase getSeveralArtistsUseCase;
    private final GetArtistAlbumUseCase getArtistAlbumUseCase;
    @GetMapping("/{id}")
    public ArtistResponse getArtist(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getArtistUseCase.execute(id, authorization);
    }
    @GetMapping
    public SeveralArtistsResponse getArtists(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getSeveralArtistsUseCase.execute(ids, authorization);
    }

    @GetMapping("/{id}/albums")
    public AlbumResponse getAlbums(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getArtistAlbumUseCase.execute(id, authorization);
    }
}
