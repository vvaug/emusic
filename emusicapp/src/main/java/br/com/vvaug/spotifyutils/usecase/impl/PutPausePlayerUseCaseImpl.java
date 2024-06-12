package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.PutPausePlayerGateway;
import br.com.vvaug.spotifyutils.usecase.PutPausePlayerUseCase;
import br.com.vvaug.spotifyutils.usecase.PutPlayerStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PutPausePlayerUseCaseImpl implements PutPausePlayerUseCase {

    private final PutPausePlayerGateway putPausePlayerGateway;

    public void execute(String deviceId, String authorization) {
        putPausePlayerGateway.pausePlayback(deviceId,authorization);
    }
}
