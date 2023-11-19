package Go2Climbmicroservices.activity_service.service;


import Go2Climbmicroservices.activity_service.enity.Activity;
import Go2Climbmicroservices.activity_service.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityService {




    public Activity GetActivityByActivityId(Integer activityId){
        return activityRepository.findActivityByActivityId(activityId);
    }
    private final ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository){

        this.activityRepository = activityRepository;
    }


public Activity AddActivity (Activity activity){

        return activityRepository.save(activity);
}


public List<Activity> ListActivity(){
        return activityRepository.findAll();
}
    public Activity getActivityById(Integer id) {
        return activityRepository.findById(id).orElse(null);
    }
public  boolean deleteByIdActivity(Integer id){
        if(activityRepository.existsById(id)){
            activityRepository.deleteById(id);
            return true;
        }
        return false;
}

}
