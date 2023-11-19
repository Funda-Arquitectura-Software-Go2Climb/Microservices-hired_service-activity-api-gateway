package Go2Climbmicroservices.activity_service.controller;


import Go2Climbmicroservices.activity_service.enity.Activity;
import Go2Climbmicroservices.activity_service.service.ActivityService;
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
    public ResponseEntity<Activity> getActivityById(@PathVariable Integer id) {
        Activity activity = activityService.getActivityById(id);
        if (activity != null) {
            return ResponseEntity.ok(activity);
        } else {
            return ResponseEntity.notFound().build();
        }
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
