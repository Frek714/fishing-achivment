package it.federico.fishingachivment.technique.dao;

import it.federico.fishingachivment.technique.model.Technique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechniqueDAO extends JpaRepository<Technique, Long> {
}
