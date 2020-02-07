package it.federico.fishingachivment.fish.service;

import it.federico.fishingachivment.fish.model.Fish;

import java.util.List;
import java.util.Optional;

public interface FishSERVICE {

    Optional<Fish> getFish(Long id);

    List<Fish> getFishes();
}
