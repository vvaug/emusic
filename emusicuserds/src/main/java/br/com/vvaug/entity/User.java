package br.com.vvaug.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private boolean premium;
    private LocalDate createdDate;
    private LocalDate lastLogin;
    private int quantityFollowers;
    private int quantityFollowing;
    private boolean active;
}
