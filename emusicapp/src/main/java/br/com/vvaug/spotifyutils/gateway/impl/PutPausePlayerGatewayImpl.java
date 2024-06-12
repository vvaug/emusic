package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.PutPausePlayerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutPausePlayerGatewayImpl implements PutPausePlayerGateway {

    private final SpotifyPlayerClient spotifyPauseClient ;

    public void pausePlayback(String deviceId, String authorization) {
        spotifyPauseClient.pausePlayback(deviceId, authorization);
    }
}