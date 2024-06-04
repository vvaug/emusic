package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class PlayerResponse {

    private PlayerDevice device;
    private String repeat_state;
    private boolean shuffle_state;
    private PlayerContext context;
    private int timestamp;
    private int progress_ms;
    private boolean is_playing;
    private PlayerItem item;
    private String currently_playing_type;
    private PlayerActions actions;

}
