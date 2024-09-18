package com.yuxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxue.entity.PlateFileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlateFileMapper extends BaseMapper<PlateFileEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(PlateFileEntity record);

    int insertSelective(PlateFileEntity record);

    PlateFileEntity selectByPrimaryKey(Integer id);

    List<PlateFileEntity> selectByCondition(Map<String, Object> map);

    int updateByPrimaryKeySelective(PlateFileEntity record);

    int updateByPrimaryKey(PlateFileEntity record);

    List<PlateFileEntity> getUnRecogniseList();
}
