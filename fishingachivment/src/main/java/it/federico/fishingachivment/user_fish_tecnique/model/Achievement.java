package it.federico.fishingachivment.user_fish_tecnique.model;

import it.federico.fishingachivment.fish.model.Fish;
import it.federico.fishingachivment.technique.model.Technique;
import it.federico.fishingachivment.user.model.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Achievement {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private Boolean caught;

    private Integer weight;

    private Integer measure;

    private Date date;

    private String place;

    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_technique")
    private Technique technique;

    @ManyToOne
    @JoinColumn(name = "id_fish")
    private Fish fish;
}
