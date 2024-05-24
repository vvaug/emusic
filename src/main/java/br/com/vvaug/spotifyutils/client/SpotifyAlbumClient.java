package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotify-get-albums-client", url = "${feign.spotify.albums.url}")
public interface SpotifyAlbumClient {

    @GetMapping("/{id}")
    AlbumResponse getAlbum(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping
    SeveralAlbumsResponse getSeveralAlbums(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping("/{id}/tracks")
    AlbumTracksResponse getAlbumTracks(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
}
