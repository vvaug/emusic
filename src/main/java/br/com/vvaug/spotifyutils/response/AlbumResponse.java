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
public class AlbumResponse {
    private String href;
    private ArrayList<ItemResponse> items;
    private int limit;
    private String next;
    private int offset;
    private Object previous;
    private int total;
}
