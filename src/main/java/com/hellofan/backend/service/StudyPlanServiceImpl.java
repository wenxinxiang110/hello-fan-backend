package com.hellofan.backend.service;

import com.hellofan.backend.mapper.StudyPlanMapper;
import com.hellofan.backend.model.StudyPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyPlanServiceImpl implements StudyPlanService {

    @Autowired
    StudyPlanMapper studyPlanMapper;

    @Override
    public List<StudyPlan> getAllPlanByName(String userName) {
        return studyPlanMapper.getAllPlan(userName);
    }

    @Override
    public boolean updateOnePlan(StudyPlan studyPlan) {
        studyPlanMapper.updateOnePlan(studyPlan);
        return true;
    }

    @Override
    public boolean updateAllPlan(List<StudyPlan> studyPlans) {

        try {
            for(StudyPlan studyPlan:studyPlans){
                studyPlanMapper.updateOnePlan(studyPlan);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAllPlan(String userName) {
        try {
            studyPlanMapper.deleteAllPlan(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}