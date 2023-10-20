package com.exatech.hired_service_service.service;

import com.exatech.hired_service_service.model.dtos.ActivityDTO;
import com.exatech.hired_service_service.model.dtos.ResponseDTO;
import com.exatech.hired_service_service.model.entity.Hired_Service;
import com.exatech.hired_service_service.repository.Hired_ServiceRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class Hired_ServiceService {

    private final Hired_ServiceRepository hired_serviceRepository;
    //inyeccion por contructor para la comunicacion entre microservicios
    private  final RestTemplate restTemplate;
    //inyectamos Webclient para solicitudes HTTP para realizar llamadas a servicios web Restful
    //Reactiva y no bloqueante
    private final WebClient.Builder webClientBuilder;
    public Hired_Service saveHired_Service(Hired_Service hired_service){
        return hired_serviceRepository.save(hired_service);
    }
    public List<Hired_Service> fetchAll() {
        return hired_serviceRepository.findAll();
    }
    public  boolean deleteByIdHired_Service(Integer id) {
        if (hired_serviceRepository.existsById(id)) {
            hired_serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseDTO getHired_ServiceById(Integer id){
        //creamos un objeto
        ResponseDTO responseDTO = new ResponseDTO();

        Hired_Service hired_service = new Hired_Service();
        hired_service = hired_serviceRepository.findById(id).get();

        //comunicacion entre microservicios

        ResponseEntity<ActivityDTO> responseEntity =
                restTemplate.getForEntity("http://localhost:8082/api/activities/"
                        + hired_service.getActivitieId() , ActivityDTO.class );

        //ahora si creamos un objeto tipo Activity
        ActivityDTO activityDTO =responseEntity.getBody();

        //ahora Pasamos nuestro aobjeto que hemos creado
        responseDTO.setHired_service(hired_service);
        responseDTO.setActivityDTO(activityDTO);
        return  responseDTO;
    }




}
