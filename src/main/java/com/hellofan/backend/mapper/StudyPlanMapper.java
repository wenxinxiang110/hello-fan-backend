package com.hellofan.backend.mapper;

import com.hellofan.backend.model.StudyPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface StudyPlanMapper {

    /**
     * @param userName 用户名
     * @return 该用户所有学习计划
     */
    List<StudyPlan> getAllPlan(@Param("userName") String userName);

    /**
     * @param studyPlan 修改一条纪录
     */
    int updateOnePlan(StudyPlan studyPlan);

    /**
     * @param studyPlans 修改所有纪录
     */
    void updateAllPlan(List<StudyPlan> studyPlans);

    /**
     * @param userName 用户名
     */
    void deleteAllPlan(@Param("userName") String userName);

    void insertOnePlan(StudyPlan studyPlan);

}
