package com.exatech.activiti_service.service;

import com.exatech.activiti_service.model.enity.Activity;
import com.exatech.activiti_service.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository){

        this.activityRepository = activityRepository;
    }

    public Activity GetByName(String name){
        return activityRepository.findByName(name);
    }



public Activity AddActivity (Activity activity){

        return activityRepository.save(activity);
}


public List<Activity> ListActivity(){
        return activityRepository.findAll();
}


public Activity GetActivityByActivityId(Integer activityId){
        return activityRepository.findActivityByActivityId(activityId);
}

public  boolean deleteByIdActivity(Integer id){
        if(activityRepository.existsById(id)){
            activityRepository.deleteById(id);
            return true;
        }
        return false;
}

}
