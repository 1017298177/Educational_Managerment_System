package com.ed.mapper;

import com.ed.pojo.Achievement;

import java.util.List;
import java.util.Map;

public interface AchievementMapper {
    int deleteByPrimaryKey(Integer achievementId);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    Achievement selectByPrimaryKey(Integer achievementId);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);

    List<Achievement> selectAchievement(Achievement achievement);

    Achievement selectScoreBySno(Map<String,String> map);

    List<Achievement> selectAchievement();

    List<Achievement> selectAchievementByUserSno(Achievement achievement);
}