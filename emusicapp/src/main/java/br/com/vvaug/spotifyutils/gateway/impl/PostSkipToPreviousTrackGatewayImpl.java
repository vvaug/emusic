package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.PostSkipToPreviousTrackGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSkipToPreviousTrackGatewayImpl implements PostSkipToPreviousTrackGateway {

    private final SpotifyPlayerClient spotifyPlayerClient;

    @Override
    public void skipToPreviousTrack(String deviceId, String authorization) {
        spotifyPlayerClient.skipToPreviousTrack(deviceId,authorization);
    }
}
