package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.request.PlayRequest;
import br.com.vvaug.spotifyutils.response.PlayerDeviceList;
import br.com.vvaug.spotifyutils.response.PlayerResponse;
import br.com.vvaug.spotifyutils.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerResource {

    private final GetPlayerStatusUseCase getPlayerStatusUseCase;
    private final PutPlayerStatusUseCase putPlayerStatusUseCase;
    private final GetPlayerAvaibleDevicesUseCase getPlayerAvaibleDevicesUseCase;
    private final PutPlayerResumeUseCase putPlayerResumeUseCase;
    private final PutPausePlayerUseCase putPausePlayerUseCase;
    private final PutSkipToNextTrackUseCase putSkipToNextTrackUseCase;
    private final PostSkipToPreviousTrackUseCase postSkipToPreviousTrackUseCase;

    @GetMapping
    PlayerResponse getPLayerState(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getPlayerStatusUseCase.execute(authorization);
    }

    void updatePlayerDevice (@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                             @RequestBody List<String> devicesId){
        putPlayerStatusUseCase.execute(authorization,devicesId);

    }

    @GetMapping("/devices")
    PlayerDeviceList getAvaibleDevices(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        return getPlayerAvaibleDevicesUseCase.execute(authorization);
    }

    @GetMapping("/play")
    void startResume (@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                      @RequestBody PlayRequest playRequest){
        putPlayerResumeUseCase.startResume(authorization,playRequest);
    }

    @PutMapping("/pause")
    void pausePlayback(
            @RequestParam("deviceId") String deviceId,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        putPausePlayerUseCase.execute(deviceId,authorization);
    }

    @PostMapping("/next")
    public void skipToNextTrack(
            @RequestParam("device_id") String deviceId,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization
    ) {
        putSkipToNextTrackUseCase.execute(deviceId, authorization);

    }

    @PostMapping("/previous")
    public void skipToPreviousTrack(
            @RequestParam("device_id") String deviceId,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization
    ) {
        postSkipToPreviousTrackUseCase.execute(authorization, deviceId);
    }


}
