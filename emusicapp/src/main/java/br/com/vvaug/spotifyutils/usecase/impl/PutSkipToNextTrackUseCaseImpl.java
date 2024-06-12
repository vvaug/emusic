package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.PutSkipToNextTrackGateway;
import br.com.vvaug.spotifyutils.usecase.PutSkipToNextTrackUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutSkipToNextTrackUseCaseImpl implements PutSkipToNextTrackUseCase {

    private final PutSkipToNextTrackGateway putSkipToNextTrackGateway;

    @Override
    public void execute(String deviceId, String authorization) {
        putSkipToNextTrackGateway.skipToNextTrack(deviceId,authorization);
    }
}
