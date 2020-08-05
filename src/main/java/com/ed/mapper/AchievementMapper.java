package com.ed.mapper;

import com.ed.pojo.Achievement;

import java.util.List;

public interface AchievementMapper {
    int deleteByPrimaryKey(Integer achievementId);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    Achievement selectByPrimaryKey(Integer achievementId);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);

    List<Achievement> selectAchievement(Achievement achievement);
}