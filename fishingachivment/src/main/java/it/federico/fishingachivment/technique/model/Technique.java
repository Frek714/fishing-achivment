package it.federico.fishingachivment.technique.model;

import it.federico.fishingachivment.user_fish_tecnique.model.Achievement;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Technique {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "technique")
    private List<Achievement> achievements = new ArrayList<>();
}
