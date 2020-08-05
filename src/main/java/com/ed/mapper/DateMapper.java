package com.ed.mapper;

import com.ed.pojo.Date;

import java.util.List;

public interface DateMapper {
    int deleteByPrimaryKey(Integer dateId);

    int insert(Date record);

    int insertSelective(Date record);

    Date selectByPrimaryKey(Integer dateId);

    Date selectDateBySemester(String semester);

    int updateByPrimaryKeySelective(Date record);

    int updateByPrimaryKey(Date record);

    List<Date> queryAll();
}