package com.delivery.project.api;

import com.delivery.project.model.Status;
import com.delivery.project.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusController {
    public Logger logger = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    StatusService statusService;

    @CrossOrigin
    @RequestMapping(value = "/status/findall", method = RequestMethod.GET)
    public ResponseEntity<List<Status>> listAllStatus (){
        List<Status> statuses = statusService.findAll();
        if(statuses.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Status>>(statuses, HttpStatus.OK);
    }

    @RequestMapping(value = "/status/find{id}", method = RequestMethod.GET)
    public Status findStatus(@PathVariable("id") int id){
        Status status = statusService.findById(id).orElseThrow();
        if(status == null){
            ResponseEntity.notFound().build();
        }
        return status;
    }

    @RequestMapping(value = "/status/add", method = RequestMethod.POST)
    public Status addStatus (@Valid @RequestBody Status status){
        return statusService.save(status);
    }
}
