package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
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

	@JsonAlias("available_markets")
	private ArrayList<String> availablemarkets;
	private ArrayList<Object> copyrights;
	private String description;
	@JsonAlias("html_description")
	private String htmlDescription;
	private boolean explicit;
	@JsonAlias("external_urls")
	private ExternalUrlsResponse externalUrls;
	private String href;
	private String id;
	private ArrayList<ImageResponse> images;
	@JsonAlias("is_externally_hosted")
	private boolean isExternallyHosted;
	private ArrayList<String> languages;
	@JsonAlias("media_type")
	private String mediaType;
	private String name;
	private String publisher;
	private String type;
	private String uri;
	@JsonAlias("total_episodes")
	private int totalEpisodes;

}
