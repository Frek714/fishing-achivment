package it.federico.fishingachivment.technique.service.implementation;

import it.federico.fishingachivment.technique.dao.TechniqueDAO;
import it.federico.fishingachivment.technique.model.Technique;
import it.federico.fishingachivment.technique.service.TechniqueSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechniqueServiceI implements TechniqueSERVICE {

    @Autowired
    private final TechniqueDAO techniqueDAO;


    @Override
    public Optional<Technique> getTechnique(Long id) {
        return techniqueDAO.findById(id);
    }

    @Override
    public List<Technique> getTechniques() {
        return techniqueDAO.findAll();
    }
}
