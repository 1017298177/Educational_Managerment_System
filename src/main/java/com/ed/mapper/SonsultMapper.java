package com.ed.mapper;

import com.ed.pojo.Sonsult;

public interface SonsultMapper {
    int deleteByPrimaryKey(Integer sonsultId);

    int insert(Sonsult record);

    int insertSelective(Sonsult record);

    Sonsult selectByPrimaryKey(Integer sonsultId);

    int updateByPrimaryKeySelective(Sonsult record);

    int updateByPrimaryKey(Sonsult record);
}