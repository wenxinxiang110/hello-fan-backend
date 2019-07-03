package com.hellofan.backend.service;

import com.hellofan.backend.model.StudyPlan;

import java.util.List;

public interface StudyPlanService {

    List<StudyPlan> getAllPlanByName(String userName);

    boolean updateOnePlan(StudyPlan studyPlan);

    boolean updateAllPlan(List<StudyPlan> studyPlans);

    boolean deleteAllPlan(String userName);

}
