package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotify-get-artists-client", url = "${feign.spotify.artists.url}")
public interface SpotifyArtistClient {

    @GetMapping("/{id}")
    ArtistResponse getArtist(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping
    SeveralArtistsResponse getArtists(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping("/{id}/albums")
    ArtistAlbumResponse getAlbums(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping("/{id}/top-tracks")
    ArtistTopTracksResponse getArtistTopTracks(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping("/{id}/related-artists")
    RelatedArtistsResponse getRelatedArtists(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
}
