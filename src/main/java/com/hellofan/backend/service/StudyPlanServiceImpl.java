package com.hellofan.backend.service;

import com.hellofan.backend.mapper.StudyPlanMapper;
import com.hellofan.backend.model.StudyPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        try {
            int affect=studyPlanMapper.updateOnePlan(studyPlan);
            if(affect==0){
                studyPlanMapper.insertOnePlan(studyPlan);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAllPlan(List<StudyPlan> studyPlans) {

        try {
            for(StudyPlan studyPlan:studyPlans){
                int affect=studyPlanMapper.updateOnePlan(studyPlan);
                if(affect==0){
                    studyPlanMapper.insertOnePlan(studyPlan);
                }
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
