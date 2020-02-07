package it.federico.fishingachivment.fish.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FishDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

}
