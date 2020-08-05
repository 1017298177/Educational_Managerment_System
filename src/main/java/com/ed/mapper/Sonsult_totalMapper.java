package com.ed.mapper;

import com.ed.pojo.Sonsult_total;

public interface Sonsult_totalMapper {
    int deleteByPrimaryKey(Integer sonsultTotalId);

    int insert(Sonsult_total record);

    int insertSelective(Sonsult_total record);

    Sonsult_total selectByPrimaryKey(Integer sonsultTotalId);

    int updateByPrimaryKeySelective(Sonsult_total record);

    int updateByPrimaryKey(Sonsult_total record);
}