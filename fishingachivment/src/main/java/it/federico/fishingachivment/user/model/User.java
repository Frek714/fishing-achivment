package it.federico.fishingachivment.user.model;

import it.federico.fishingachivment.user_fish_tecnique.model.Achievement;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Achievement> achievements = new ArrayList<>();
}
