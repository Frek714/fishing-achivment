package it.federico.fishingachivment.fish.controller;

import it.federico.fishingachivment.fish.dto.FishDto;
import it.federico.fishingachivment.fish.model.Fish;
import it.federico.fishingachivment.fish.service.FishSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("fish/")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class FishCONTROLLER {

    private final FishSERVICE fishSERVICE;

    @GetMapping("get/{id}") // Return FishDto
    public ResponseEntity getFish(@PathVariable("id") Long id) {
        Fish fish = fishSERVICE.getFish(id).orElse(null);
        if (fish == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This fish does not exist.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertEntitytoDto(fish));
    }

    @GetMapping("getAll") // Return List<FishDto>
    public ResponseEntity getFishes() {
        List<Fish> fishes = fishSERVICE.getFishes();
        if (fishes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Fishes found.");
        }
        List<FishDto> fishDtos = new ArrayList<>();
        fishes.forEach(fish -> fishDtos.add(convertEntitytoDto(fish)));
        return ResponseEntity.status(HttpStatus.OK).body(fishDtos);
    }

    private FishDto convertEntitytoDto(Fish fish) {
        FishDto fishDto = new FishDto();
        fishDto.setId(fish.getId());
        fishDto.setName(fish.getName());

        return fishDto;
    }

//    private Fish converterDtotoEntity(FishDto fishDto) {
//        Fish fish = new Fish();
//        fish.setName(fishDto.getName());
//
//        return fish;
//    }
}
