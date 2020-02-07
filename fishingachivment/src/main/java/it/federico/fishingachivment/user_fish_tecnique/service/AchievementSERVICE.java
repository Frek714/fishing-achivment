package it.federico.fishingachivment.user_fish_tecnique.service;

import it.federico.fishingachivment.user_fish_tecnique.model.Achievement;

import java.util.List;
import java.util.Optional;

public interface AchievementSERVICE {

    Optional<Achievement> getAchievement(Long id);

    List<Achievement> getAchievements();

    Achievement postAchievement(Achievement achievement);

    void updateAchievement(Long id, Achievement achievement);
}
