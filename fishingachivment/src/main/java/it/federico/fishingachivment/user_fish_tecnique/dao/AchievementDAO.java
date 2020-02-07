package it.federico.fishingachivment.user_fish_tecnique.dao;

import it.federico.fishingachivment.user_fish_tecnique.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementDAO extends JpaRepository<Achievement, Long> {
}
