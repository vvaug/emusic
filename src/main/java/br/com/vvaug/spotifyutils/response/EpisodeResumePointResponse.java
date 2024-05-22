package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class EpisodeResumePointResponse {
	
    private boolean fully_played;
    private int resume_position_ms;

}
