package br.com.vvaug.emusicregister.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String documentNumber;

}
