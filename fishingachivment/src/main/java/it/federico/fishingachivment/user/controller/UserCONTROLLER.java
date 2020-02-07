package it.federico.fishingachivment.user.controller;


import it.federico.fishingachivment.user.dto.UserDto;
import it.federico.fishingachivment.user.dto.UserRequestDto;
import it.federico.fishingachivment.user.model.User;
import it.federico.fishingachivment.user.service.UserSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user/")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UserCONTROLLER {

    private final UserSERVICE userSERVICE;

    @GetMapping("get/{id}") //return UserDTO
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        User user = userSERVICE.getUser(id).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This User does not exist.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertEntitytoDto(user));
    }

    @GetMapping("getAll") //return List<UserDTO>
    public ResponseEntity getUsers() {
        List<User> users = userSERVICE.getUsers();
        if (users == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Users found.");
        }
        List<UserDto> userDTOS = new ArrayList<>();
        users.forEach(user -> userDTOS.add(convertEntitytoDto(user)));
        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }

    @PostMapping("post") //return UserDTO
    public ResponseEntity postUser(@RequestBody UserRequestDto userRequestDto) {
        try {
            User user = userSERVICE.postUser(converterDtotoEntity(userRequestDto));
            return ResponseEntity.status(HttpStatus.OK).body(convertEntitytoDto(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This User can not be added.");
        }
    }

    private UserDto convertEntitytoDto (User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    private User converterDtotoEntity (UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return user;
    }

    private User converterDtotoEntity (UserRequestDto userRequestDto) {
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());

        return user;
    }
}
