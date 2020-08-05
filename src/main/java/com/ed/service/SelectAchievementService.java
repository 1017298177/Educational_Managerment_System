package com.ed.service;

import com.ed.pojo.Achievement;

import java.util.Map;

public interface SelectAchievementService {
    Map<String, Object> pageMap(Achievement achievement);
}
