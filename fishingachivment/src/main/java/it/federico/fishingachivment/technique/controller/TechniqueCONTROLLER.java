package it.federico.fishingachivment.technique.controller;

import it.federico.fishingachivment.technique.dto.TechniqueDto;
import it.federico.fishingachivment.technique.model.Technique;
import it.federico.fishingachivment.technique.service.TechniqueSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("technique/")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class TechniqueCONTROLLER {

    private final TechniqueSERVICE techniqueSERVICE;

    @GetMapping("get/{id}") // Return TechniqueDto
    public ResponseEntity getTechnique(@PathVariable("id") Long id) {
        Technique technique = techniqueSERVICE.getTechnique(id).orElse(null);
        if (technique == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Technique does not exist.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertEntitytoDto(technique));
    }

    @GetMapping("getAll") // Return List<TechniqueDto>
    public ResponseEntity getTechniques() {
        List<Technique> techniques = techniqueSERVICE.getTechniques();
        if (techniques == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Techniques found.");
        }
        List<TechniqueDto> techniqueDtos = new ArrayList<>();
        techniques.forEach(technique -> techniqueDtos.add(convertEntitytoDto(technique)));
        return ResponseEntity.status(HttpStatus.OK).body(techniqueDtos);
    }

    private TechniqueDto convertEntitytoDto(Technique technique) {
        TechniqueDto techniqueDto = new TechniqueDto();
        techniqueDto.setId(technique.getId());
        techniqueDto.setName(technique.getName());
//        List<Long> achievementIDs = new ArrayList<>();
//        technique.getAchievements().forEach(achievement -> achievementIDs.add(achievement.getId()));

        return techniqueDto;
    }

//    private Technique converterDtotoEntity (TechniqueDto techniqueDto) {
//        Technique technique = new Technique();
//        technique.setName(techniqueDto.getName());
//
//        return technique;
//    }
}
