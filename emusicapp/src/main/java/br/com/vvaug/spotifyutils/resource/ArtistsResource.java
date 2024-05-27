package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.*;
import br.com.vvaug.spotifyutils.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistsResource {

    private final GetArtistUseCase getArtistUseCase;
    private final GetSeveralArtistsUseCase getSeveralArtistsUseCase;
    private final GetArtistAlbumUseCase getArtistAlbumUseCase;
    private final GetArtistTopTracksUseCase getArtistTopTracksUseCase;
    private final GetRelatedArtistsUseCase getRelatedArtistsUseCase;
    @GetMapping("/{id}")
    public ArtistResponse getArtist(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getArtistUseCase.execute(id, authorization);
    }
    @GetMapping
    public SeveralArtistsResponse getArtists(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getSeveralArtistsUseCase.execute(ids, authorization);
    }

    @GetMapping("/{id}/albums")
    public ArtistAlbumResponse getAlbums(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getArtistAlbumUseCase.execute(id, authorization);
    }

    @GetMapping("/{id}/top-tracks")
    public ArtistTopTracksResponse getArtistTopTracks(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getArtistTopTracksUseCase.execute(id, authorization);
    }
    @GetMapping("/{id}/related-artists")
    public RelatedArtistsResponse getRelatedArtists(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getRelatedArtistsUseCase.execute(id, authorization);
    }
}
