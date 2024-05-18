package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SeveralCategoriesResponse {
	
	private CategoriesResponse categories;

}
