package az.coders.tourmanagement.model;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String username;
    private String password;
    private String email;
    private Set<String> role;
}