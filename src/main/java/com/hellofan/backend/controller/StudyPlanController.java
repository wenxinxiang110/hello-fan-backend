package com.hellofan.backend.controller;

import com.hellofan.backend.dto.StudyPlanDto;
import com.hellofan.backend.model.StudyPlan;
import com.hellofan.backend.service.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("studyPlan")
public class StudyPlanController {

    @Autowired
    StudyPlanService studyPlanService;

    /**
     * @param userName 用户名
     * @return ArrayList<StudyPlan> 该用户所有学习纪录
     */
    @GetMapping("/getAllPlan")
    public List<StudyPlan> getAllPlan(String userName) {
        List<StudyPlan> studyPlans=new ArrayList<>();
        studyPlans=studyPlanService.getAllPlanByName(userName);
        return studyPlans ;
    }

    /**
     * @param studyPlans
     * @return
     */
    @PostMapping("/updateAllPlan")
    public boolean updateAllPlan(@RequestBody List<StudyPlan> studyPlans) {
        return studyPlanService.updateAllPlan(studyPlans) ;
    }

    /**
     * @param studyPlan
     */
    @PostMapping("/updateOnePlan")
    public boolean updateOnePlan(@RequestBody StudyPlan studyPlan){
        return studyPlanService.updateOnePlan(studyPlan);
    }

    /**
     * @param userName 用户名
     * @return 是否删除成功
     */
    @GetMapping("/deleteAll")
    public boolean deleteAllPlan(String userName){
        return studyPlanService.deleteAllPlan(userName);
    }



}
