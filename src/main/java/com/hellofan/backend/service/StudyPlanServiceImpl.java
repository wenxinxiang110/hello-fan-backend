package com.hellofan.backend.service;

import com.hellofan.backend.mapper.StudyPlanMapper;
import com.hellofan.backend.mapper.UserMapper;
import com.hellofan.backend.model.StudyPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudyPlanServiceImpl implements StudyPlanService {

    @Autowired
    StudyPlanMapper studyPlanMapper;
    @Autowired
    UserMapper userMapper;

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
            String name=studyPlan.getUserName();
            //修改日期
            Date newdate=studyPlanMapper.getUpdateTime(name);
            userMapper.updateUserTime(name,newdate);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAllPlan(List<StudyPlan> studyPlans) {

        try {
            String name=studyPlans.get(0).getUserName();
            for(StudyPlan studyPlan:studyPlans){
                int affect=studyPlanMapper.updateOnePlan(studyPlan);
                if(affect==0){
                    studyPlanMapper.insertOnePlan(studyPlan);
                }
            }
            //修改日期
            Date newdate=studyPlanMapper.getUpdateTime(name);
            userMapper.updateUserTime(name,newdate);
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
