package com.exatech.hired_service_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer  service_id;
}
