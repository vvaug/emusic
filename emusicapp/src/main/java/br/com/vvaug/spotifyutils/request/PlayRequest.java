package br.com.vvaug.spotifyutils.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayRequest {
    private String context_uri;
    private Offset offset;
    private int position_ms;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Offset {
        private int position;
    }
}

