package com.hellofan.backend.mapper.generator;

import com.hellofan.backend.model.generator.StudyPlan;
import com.hellofan.backend.model.generator.StudyPlanExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StudyPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudyPlan record);

    int insertSelective(StudyPlan record);

    List<StudyPlan> selectByExampleWithBLOBs(StudyPlanExample example);

    List<StudyPlan> selectByExample(StudyPlanExample example);

    StudyPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudyPlan record, @Param("example") StudyPlanExample example);

    int updateByExampleWithBLOBs(@Param("record") StudyPlan record, @Param("example") StudyPlanExample example);

    int updateByExample(@Param("record") StudyPlan record, @Param("example") StudyPlanExample example);

    int updateByPrimaryKeySelective(StudyPlan record);

    int updateByPrimaryKeyWithBLOBs(StudyPlan record);

    int updateByPrimaryKey(StudyPlan record);
}