package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemResponse {
    @JsonAlias("album_group")
    private String albumGroup;
    @JsonAlias("album_type")
    private String albumType;
    private ArrayList<ArtistResponse> artists;
    @JsonAlias("available_markets")
    private ArrayList<String> availableMarkets;
    @JsonAlias("external_urls")
    private ExternalUrlsResponse externalUrls;
    private String href;
    private String id;
    private ArrayList<ImageResponse> images;
    private String name;
    @JsonAlias("release_date")
    private String releaseDate;
    @JsonAlias("release_date_precision")
    private String releaseDatePrecision;
    @JsonAlias("total_tracks")
    private int totalTracks;
    private String type;
    private String uri;

}
