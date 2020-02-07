package it.federico.fishingachivment.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private List<Long> achievements = new ArrayList<>();
}
