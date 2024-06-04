package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerActions {

    private boolean interrupting_playback;
    private boolean pausing;
    private boolean resuming;
    private boolean seeking;
    private boolean skipping_next;
    private boolean skipping_prev;
    private boolean toggling_repeat_context;
    private boolean toggling_shuffle;
    private boolean toggling_repeat_track;
    private boolean transferring_playback;

}
