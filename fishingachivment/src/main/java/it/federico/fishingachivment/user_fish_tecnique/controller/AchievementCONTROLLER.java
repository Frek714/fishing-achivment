package it.federico.fishingachivment.user_fish_tecnique.controller;

import it.federico.fishingachivment.fish.model.Fish;
import it.federico.fishingachivment.fish.service.FishSERVICE;
import it.federico.fishingachivment.technique.model.Technique;
import it.federico.fishingachivment.technique.service.TechniqueSERVICE;
import it.federico.fishingachivment.user.model.User;
import it.federico.fishingachivment.user.service.UserSERVICE;
import it.federico.fishingachivment.user_fish_tecnique.dto.AchievementDto;
import it.federico.fishingachivment.user_fish_tecnique.dto.AchievementRequestDto;
import it.federico.fishingachivment.user_fish_tecnique.model.Achievement;
import it.federico.fishingachivment.user_fish_tecnique.service.AchievementSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("achievement/")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class AchievementCONTROLLER {

    private final AchievementSERVICE achievementSERVICE;
    private final FishSERVICE fishSERVICE;
    private final TechniqueSERVICE techniqueSERVICE;
    private final UserSERVICE userSERVICE;

    @GetMapping("get/{id}") //return AchievementDTO
    public ResponseEntity getAchievement(@PathVariable("id") Long id) {
        Achievement achievement = achievementSERVICE.getAchievement(id).orElse(null);
        if (achievement == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This User does not exist.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertEntityToDto(achievement));
    }

    @GetMapping("getAll") //return List<AchievementDTO>
    public ResponseEntity getUsers() {
        List<Achievement> achievements = achievementSERVICE.getAchievements();
        if (achievements == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Achievement found.");
        }
        List<AchievementDto> achievementDtos = new ArrayList<>();
        achievements.forEach(achievement -> achievementDtos.add(convertEntityToDto(achievement)));
        return ResponseEntity.status(HttpStatus.OK).body(achievementDtos);
    }

    @PostMapping("post") //return AchievementDto
    public ResponseEntity postAchievement(@RequestBody AchievementRequestDto achievementRequestDto) {
        try {
            Fish fish = fishSERVICE.getFish(achievementRequestDto.getFish()).orElse(null);
            if (fish == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fish not Found.");
            }
            Technique technique = techniqueSERVICE.getTechnique(achievementRequestDto.getTechnique()).orElse(null);
            if (technique == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Technique not Found.");
            }
            User user = userSERVICE.getUser(achievementRequestDto.getUser()).orElse(null);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found.");
            }

            Achievement achievement = achievementSERVICE.postAchievement(converterDtoToEntity(achievementRequestDto, fish, user, technique));
            return ResponseEntity.status(HttpStatus.OK).body(convertEntityToDto(achievement));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This User can not be added.");
        }
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody AchievementRequestDto achievementRequestDto) {
        fishSERVICE.getFish(achievementRequestDto.getFish())
                .ifPresent(fish -> techniqueSERVICE.getTechnique(achievementRequestDto.getTechnique())
                        .ifPresent(technique -> userSERVICE.getUser(achievementRequestDto.getUser())
                                .ifPresent(user -> achievementSERVICE.updateAchievement(id, converterDtoToEntity(achievementRequestDto, fish, user, technique)))));
    }


    private Achievement converterDtoToEntity(AchievementDto achievementDto, Fish fish, User user, Technique technique) {
        Achievement achievement = new Achievement();
        achievement.setPlace(achievementDto.getPlace());
        achievement.setWeight(achievementDto.getWeight());
        achievement.setPhoto(achievementDto.getPhoto());
        achievement.setMeasure(achievementDto.getMeasure());
        achievement.setDate(achievementDto.getDate());
        achievement.setCaught(achievementDto.getCaught());
        achievement.setFish(fish);
        achievement.setUser(user);
        achievement.setTechnique(technique);

        return achievement;
    }

    private Achievement converterDtoToEntity(AchievementRequestDto achievementRequestDto, Fish fish, User user, Technique technique) {
        Achievement achievement = new Achievement();
        achievement.setPlace(achievementRequestDto.getPlace());
        achievement.setWeight(achievementRequestDto.getWeight());
        achievement.setPhoto(achievementRequestDto.getPhoto());
        achievement.setMeasure(achievementRequestDto.getMeasure());
        achievement.setDate(achievementRequestDto.getDate());
        achievement.setCaught(achievementRequestDto.getCaught());
        achievement.setFish(fish);
        achievement.setUser(user);
        achievement.setTechnique(technique);

        return achievement;
    }

    private AchievementDto convertEntityToDto(Achievement achievement) {
        AchievementDto achievementDto = new AchievementDto();
        achievementDto.setPlace(achievement.getPlace());
        achievementDto.setWeight(achievement.getWeight());
        achievementDto.setPhoto(achievement.getPhoto());
        achievementDto.setMeasure(achievement.getMeasure());
        achievementDto.setDate(achievement.getDate());
        achievementDto.setCaught(achievement.getCaught());
        achievementDto.setFish(achievement.getFish().getId());
        achievementDto.setUser(achievement.getUser().getId());
        achievementDto.setTechnique(achievement.getTechnique().getId());
        achievementDto.setId(achievement.getId());

        return achievementDto;
    }


}
