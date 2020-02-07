package it.federico.fishingachivment.user_fish_tecnique.service.implementation;

import it.federico.fishingachivment.user_fish_tecnique.dao.AchievementDAO;
import it.federico.fishingachivment.user_fish_tecnique.model.Achievement;
import it.federico.fishingachivment.user_fish_tecnique.service.AchievementSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AchievementServiceI implements AchievementSERVICE {

    @Autowired
    private final AchievementDAO achievementDAO;


    @Override
    public Optional<Achievement> getAchievement(Long id) {
        return achievementDAO.findById(id);
    }

    @Override
    public List<Achievement> getAchievements() {
        return achievementDAO.findAll();
    }

    @Override
    public Achievement postAchievement(Achievement achievement) {
        return achievementDAO.save(achievement);
    }

    @Override
    public void updateAchievement(Long id, Achievement achievement) {
        achievementDAO.findById(id).ifPresent(a -> achievementDAO.save(setAchievementField(a, achievement)));
    }

    private Achievement setAchievementField(Achievement a, Achievement achievement) {
        a.setCaught(achievement.getCaught());
        a.setDate(achievement.getDate());
        a.setMeasure(achievement.getMeasure());
        a.setPhoto(achievement.getPhoto());
        a.setWeight(achievement.getWeight());
        a.setPlace(achievement.getPlace());
        a.setFish(achievement.getFish());
        a.setUser(achievement.getUser());
        a.setTechnique(achievement.getTechnique());

        return a;
    }
}
