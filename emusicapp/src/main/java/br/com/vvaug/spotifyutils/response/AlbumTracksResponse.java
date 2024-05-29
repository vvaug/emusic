package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumTracksResponse {

    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
    private List<AlbumItemResponse> items;
}
