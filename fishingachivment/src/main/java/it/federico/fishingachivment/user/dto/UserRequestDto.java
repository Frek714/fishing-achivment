package it.federico.fishingachivment.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private List<Long> achievements = new ArrayList<>();
}
