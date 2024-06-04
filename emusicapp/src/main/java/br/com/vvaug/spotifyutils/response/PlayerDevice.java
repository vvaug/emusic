package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PlayerDevice {

    private String id;
    private boolean is_active;
    private boolean is_private_session;
    private boolean is_restricted;
    private String name;
    private String type;
    private int volume_percent;
    private boolean supports_volume;

}
