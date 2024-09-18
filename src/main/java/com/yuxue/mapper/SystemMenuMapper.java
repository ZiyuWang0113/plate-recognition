package com.yuxue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxue.entity.SystemMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SystemMenuMapper extends BaseMapper<SystemMenuEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemMenuEntity record);

    int insertSelective(SystemMenuEntity record);

    SystemMenuEntity selectByPrimaryKey(Integer id);

    List<SystemMenuEntity> selectByCondition(Map<String, Object> map);

    int updateByPrimaryKeySelective(SystemMenuEntity record);

    int updateByPrimaryKey(SystemMenuEntity record);
}
