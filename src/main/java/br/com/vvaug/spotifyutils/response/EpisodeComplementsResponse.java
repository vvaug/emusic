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

public class EpisodeComplementsResponse {
	
	private ArrayList<String> available_markets;
	private ArrayList<Object> copyrights;
	private String description;
	private String html_description;
	private boolean explicit;
	private ExternalUrlsResponse external_urls;
	private String href;
	private String id;
	private ArrayList<ImageResponse> images;
	private boolean is_externally_hosted;
	private ArrayList<String> languages;
	private String media_type;
	private String name;
	private String publisher;
	private String type;
	private String uri;
	private int total_episodes;

}
