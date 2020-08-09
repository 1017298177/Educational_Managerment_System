package com.ed.service;

import com.ed.pojo.Achievement;

import java.util.List;

public interface AchievementService {
    Achievement selectScoreBySno(String userSno);

    List<Achievement> selectAchievement();

    Achievement selectAchievementById(Integer achievementId);

    int updateAchievementByAchievement(Achievement achievement);

    int inserAchievementById(Achievement achievement);
}
