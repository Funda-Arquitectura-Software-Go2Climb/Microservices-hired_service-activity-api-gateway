package com.exatech.activiti_service.controller;

import com.exatech.activiti_service.model.enity.Activity;
import com.exatech.activiti_service.repository.ActivityRepository;
import com.exatech.activiti_service.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;
    public ActivityController(ActivityService activityService){
        this.activityService = activityService;
    }

    @PostMapping
    public Activity AddActivity(@RequestBody Activity activity) {
        return activityService.AddActivity(activity);
    }
    @GetMapping
    public List<Activity> ListALL() {
        return activityService.ListActivity();
    }

    @GetMapping("/{id}")
    public Activity GetByIdActivity(@PathVariable Integer id){
        return activityService.GetActivityByActivityId(id);
}

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(activityService.deleteByIdActivity(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
}
}
