package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.PutPlayerStatusGateway;
import br.com.vvaug.spotifyutils.usecase.PutPlayerStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PutPlayerStatusUseCaseImpl implements PutPlayerStatusUseCase {

    private final PutPlayerStatusGateway putPlayerStatusGateway;

    @Override
    public void execute(String authorization, List<String> devicesId) {
        putPlayerStatusGateway.updatePlayerDevice(authorization,devicesId);

    }
}
