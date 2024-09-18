package com.yuxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxue.entity.TempPlateFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TempPlateFileMapper extends BaseMapper<TempPlateFileEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(TempPlateFileEntity record);

    int insertSelective(TempPlateFileEntity record);

    TempPlateFileEntity selectByPrimaryKey(Integer id);

    List<TempPlateFileEntity> selectByCondition(Map<String, Object> map);

    int updateByPrimaryKeySelective(TempPlateFileEntity record);

    int updateByPrimaryKey(TempPlateFileEntity record);

    int turncateTable();

    int batchInsert(@Param("list")List<TempPlateFileEntity> list);

    int updateFileInfo();


}
