package it.federico.fishingachivment.user_fish_tecnique.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AchievementRequestDto {

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
