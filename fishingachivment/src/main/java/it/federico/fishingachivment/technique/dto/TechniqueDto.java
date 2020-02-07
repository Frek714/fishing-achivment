package it.federico.fishingachivment.technique.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TechniqueDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;
}
