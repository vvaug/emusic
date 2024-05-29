package br.com.vvaug.response;


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

    private String firstName;
    private String lastName;
    private String documentNumber;
    private boolean premium;
    private LocalDate createdDate;
    private boolean active;

}
