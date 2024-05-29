package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class EpisodeResumePointResponse {

    @JsonAlias("fully_played")
    private boolean fullyPlayed;
    @JsonAlias("resume_position_ms")
    private int resumePositionMs;

}
