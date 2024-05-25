package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SeveralEpisodesResponse {
	
	private ArrayList<EpisodeResponse> episodes;

}
