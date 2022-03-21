package az.coders.tourmanagement.dto;

import az.coders.tourmanagement.entity.Role;
import az.coders.tourmanagement.entity.TourEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long userId;

    private String name;

    private String email;

    private String password;

    private Set<Role> roles;

    private Set<TourDTO> tours;

    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
