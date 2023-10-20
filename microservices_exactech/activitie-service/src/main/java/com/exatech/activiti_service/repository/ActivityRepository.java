package com.exatech.activiti_service.repository;

import com.exatech.activiti_service.model.enity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
