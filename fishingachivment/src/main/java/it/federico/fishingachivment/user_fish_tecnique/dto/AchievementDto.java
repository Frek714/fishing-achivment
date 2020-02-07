package it.federico.fishingachivment.user_fish_tecnique.dto;

import it.federico.fishingachivment.fish.model.Fish;
import it.federico.fishingachivment.technique.model.Technique;
import it.federico.fishingachivment.user.model.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AchievementDto {

    @NotNull
    private Long id;

    @NotNull
    private Boolean caught;

    private Integer weight;

    private Integer measure;

    private Date date;

    private String place;

    private byte[] photo;

    @NotNull
    private Long user;

    @NotNull
    private Long technique;

    @NotNull
    private Long fish;
}
