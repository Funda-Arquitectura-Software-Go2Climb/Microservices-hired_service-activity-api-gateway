package com.exatech.hired_service_service.controller;

import com.exatech.hired_service_service.model.dtos.ResponseDTO;
import com.exatech.hired_service_service.model.entity.Hired_Service;
import com.exatech.hired_service_service.service.Hired_ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hired_services")
@AllArgsConstructor
public class Hired_ServiceController {
    private final Hired_ServiceService hired_serviceService;

    @PostMapping
    public Hired_Service saveHired_Service(@RequestBody Hired_Service hired_service){
        return hired_serviceService.saveHired_Service(hired_service);
    }

    @GetMapping
    public List<Hired_Service> fetchAll() {
        return hired_serviceService.fetchAll();
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(hired_serviceService.deleteByIdHired_Service(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseDTO getHired_ServiceById(@PathVariable Integer id){
        return hired_serviceService.getHired_ServiceById(id);
    }



}
