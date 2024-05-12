package br.com.vvaug.spotifyutils.response;

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
    private String album_group;
    private String album_type;
    private ArrayList<ArtistResponse> artists;
    private ArrayList<String> available_markets;
    private ExternalUrlsResponse external_urls;
    private String href;
    private String id;
    private ArrayList<ImageResponse> images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private int total_tracks;
    private String type;
    private String uri;

}
