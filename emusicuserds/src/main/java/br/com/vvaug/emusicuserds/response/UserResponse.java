package br.com.vvaug.emusicuserds.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponse {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private boolean premium;
    private LocalDate createdDate;
    private boolean active;

}
