package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.PutPlayerResumeGateway;
import br.com.vvaug.spotifyutils.request.PlayRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutPlayerResumeGatewayImpl implements PutPlayerResumeGateway {

    private final SpotifyPlayerClient spotifyPlayerClient;

    @Override
    public void startResume(String authorization, PlayRequest playRequest) {
        spotifyPlayerClient.startResume(authorization,playRequest);
    }
}
