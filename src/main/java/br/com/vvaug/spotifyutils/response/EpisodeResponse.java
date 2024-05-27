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

public class EpisodeResponse {

	@JsonAlias("audio_preview_url")
	private String AudioPreviewUrl;
	private String description;
	@JsonAlias("html_description")
	private String htmlDescription;
	@JsonAlias("duration_ms")
	private int durationMs;
	private boolean explicit;
	@JsonAlias("external_urls")
	private ExternalUrlsResponse externalUrls;
	private String href;
	private String id;
	private ArrayList<ImageResponse> images;
	@JsonAlias("is_externally_hosted")
	private boolean isExternallyHosted;
	@JsonAlias("is_playable")
	private boolean isPlayable;
	private String language;
	private ArrayList<String> languages;
	private String name;
	@JsonAlias("release_date")
	private String releaseDate;
	@JsonAlias("release_date_precision")
    private String releaseDatePrecision;
	@JsonAlias("resume_point")
    private EpisodeResumePointResponse resumePoint;
    private String type;
    private String uri;
    private EpisodeComplementsResponse episodeComplementsResponse;

}
