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
public class CategoriesItemResponse {
	
	private String href;
	private ArrayList<ImageResponse> icons;
	private String id;
	private String name;

}
