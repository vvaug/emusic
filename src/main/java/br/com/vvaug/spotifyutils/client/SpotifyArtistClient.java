package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "spotify-get-artists-client", url = "${feign.spotify.artists.url}")
public interface SpotifyArtistClient {

    @GetMapping("/{id}")
    public ArtistResponse getArtist(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping
    public SeveralArtistsResponse getArtists(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping("/{id}/albums")
    public AlbumResponse getAlbums(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @GetMapping("/{id}/top-tracks")
    public ArtistTopTracksResponse getArtistTopTracks(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
}
