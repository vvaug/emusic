package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.PutSkipToNextTrackGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutSkipToNextTrackGatewayImpl implements PutSkipToNextTrackGateway {

    private final SpotifyPlayerClient spotifyPlayerClient;

    @Override
    public void skipToNextTrack(String deviceId, String authorization) {
        spotifyPlayerClient.skipToNextTrack(deviceId,authorization);
    }
}
