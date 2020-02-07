package it.federico.fishingachivment.technique.service;

import it.federico.fishingachivment.technique.model.Technique;

import java.util.List;
import java.util.Optional;

public interface TechniqueSERVICE {

    Optional<Technique> getTechnique(Long id);

    List<Technique> getTechniques();
}
