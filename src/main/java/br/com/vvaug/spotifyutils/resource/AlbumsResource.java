package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import br.com.vvaug.spotifyutils.usecase.GetAlbumTracksUseCase;
import br.com.vvaug.spotifyutils.usecase.GetAlbumUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralAlbumsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumsResource {

    private final GetAlbumUseCase getAlbumUseCase;
    private final GetSeveralAlbumsUseCase getSeveralAlbumsUseCase;
    private final GetAlbumTracksUseCase getAlbumTracksUseCase;
    
    @GetMapping("/{id}")
    public AlbumResponse getAlbum(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getAlbumUseCase.execute(id, authorization);
    }
    @GetMapping
    public SeveralAlbumsResponse getSeveralAlbums(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        return getSeveralAlbumsUseCase.execute(ids, authorization);
    }

    @GetMapping("/{id}/tracks")
    public AlbumTracksResponse getAlbumTracks(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getAlbumTracksUseCase.execute(id, authorization);
    }
}
    //TODO Get New Releases (/browse/new-releases)

