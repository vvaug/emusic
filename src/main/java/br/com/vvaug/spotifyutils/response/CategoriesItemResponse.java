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
public class CategoriesItemResponse {
	
	private String href;
	private ArrayList<ImageResponse> icons;
	private String id;
	private String name;

}
