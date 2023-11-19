package Go2Climbmicroservices.activity_service.repository;


import Go2Climbmicroservices.activity_service.enity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {



    Activity findByName(String name);
    Activity findActivityByActivityId(Integer activityId);


}
