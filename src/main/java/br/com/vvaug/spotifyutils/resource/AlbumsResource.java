package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.usecase.GetAlbumUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumsResource {

    private final GetAlbumUseCase getAlbumUseCase;
    @GetMapping("/{id}")
    public AlbumResponse getAlbum(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getAlbumUseCase.execute(id, authorization);
    }
}
