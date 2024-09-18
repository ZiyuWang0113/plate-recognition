package com.yuxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxue.entity.PlateRecoDebugEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlateRecoDebugMapper extends BaseMapper<PlateRecoDebugEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(PlateRecoDebugEntity record);

    int insertSelective(PlateRecoDebugEntity record);

    PlateRecoDebugEntity selectByPrimaryKey(Integer id);

    List<PlateRecoDebugEntity> selectByCondition(Map<String, Object> map);

    int updateByPrimaryKeySelective(PlateRecoDebugEntity record);

    int updateByPrimaryKey(PlateRecoDebugEntity record);

    int deleteByParentId(@Param("parentId")Integer parentId);

    int batchInsert(@Param("list")List<PlateRecoDebugEntity> list);
}
