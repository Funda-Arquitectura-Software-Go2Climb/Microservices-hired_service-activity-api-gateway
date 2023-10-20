package com.exatech.hired_service_service.model.dtos;

import com.exatech.hired_service_service.model.entity.Hired_Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Hired_Service hired_service;
    private ActivityDTO  activityDTO;
    private CustomerDTO customerDTO;
}
