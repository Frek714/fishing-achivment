package it.federico.fishingachivment.fish.service.implementation;

import it.federico.fishingachivment.fish.dao.FishDAO;
import it.federico.fishingachivment.fish.model.Fish;
import it.federico.fishingachivment.fish.service.FishSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FishServiceI implements FishSERVICE {

    @Autowired
    private final FishDAO fishDAO;


    @Override
    public Optional<Fish> getFish(Long id) {
        return fishDAO.findById(id);
    }

    @Override
    public List<Fish> getFishes() {
        return fishDAO.findAll();
    }
}
