package com.ed.mapper;

import com.ed.pojo.Class;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer claasId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer claasId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}