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

public class EpisodeResponse {
	
	private String audio_preview_url;
	private String description;
	private String html_description;
	private int duration_ms;
	private boolean explicit;
	private ExternalUrlsResponse external_urls;
	private String href;
	private String id;
	private ArrayList<ImageResponse> images;
	private boolean is_externally_hosted;
	private boolean is_playable;
	private String language;
	private ArrayList<String> languages;
	private String name;
	private String release_date;
    private String release_date_precision;
    private EpisodeResumePointResponse resume_point;
    private String type;
    private String uri;
    private EpisodeComplementsResponse episodeComplementsResponse;

}
