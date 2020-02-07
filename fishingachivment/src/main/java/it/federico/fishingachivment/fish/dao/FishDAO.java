package it.federico.fishingachivment.fish.dao;

import it.federico.fishingachivment.fish.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishDAO extends JpaRepository<Fish, Long> {
}
