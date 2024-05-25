package br.com.vvaug.spotifyutils.response;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class GenresResponse {
	
	private ArrayList<String> genres;
}
