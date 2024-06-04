package br.com.vvaug.spotifyutils.usecase;

import java.util.List;

public interface PutPlayerStatusUseCase {

    void execute(String authorization, List<String> devicesId);

}
