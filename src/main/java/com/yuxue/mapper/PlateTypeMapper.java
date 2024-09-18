package com.yuxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxue.entity.PlateTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlateTypeMapper extends BaseMapper<PlateTypeEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(PlateTypeEntity record);

    int insertSelective(PlateTypeEntity record);

    PlateTypeEntity selectByPrimaryKey(Integer id);

    List<PlateTypeEntity> selectByCondition(Map map);

    int updateByPrimaryKeySelective(PlateTypeEntity record);

    int updateByPrimaryKey(PlateTypeEntity record);
}
