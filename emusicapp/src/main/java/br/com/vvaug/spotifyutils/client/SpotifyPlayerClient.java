package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.request.PlayRequest;
import br.com.vvaug.spotifyutils.response.PlayerDeviceList;
import br.com.vvaug.spotifyutils.response.PlayerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="spotify-get-markets-client",url="${feign.spotify.player.url}")
public interface SpotifyPlayerClient {

    @GetMapping("/player")
    PlayerResponse getPLayerState(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @PutMapping("/player")
    void updatePlayerDevice(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                            @RequestBody List<String> devicesId);
    @GetMapping("player/devices")
    PlayerDeviceList getAvaibleDevices(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

    @PutMapping("player/play")
    void startResume(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                     @RequestBody PlayRequest playRequest);

}
