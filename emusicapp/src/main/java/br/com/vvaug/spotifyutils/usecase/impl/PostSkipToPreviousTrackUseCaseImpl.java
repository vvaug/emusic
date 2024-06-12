package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.PostSkipToPreviousTrackGateway;
import br.com.vvaug.spotifyutils.usecase.PostSkipToPreviousTrackUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSkipToPreviousTrackUseCaseImpl implements PostSkipToPreviousTrackUseCase {

    private final PostSkipToPreviousTrackGateway postSkipToPreviousTrackGateway;

    @Override
    public void execute(String deviceId, String authorization) {
        postSkipToPreviousTrackGateway.skipToPreviousTrack(deviceId,authorization);
    }
}
