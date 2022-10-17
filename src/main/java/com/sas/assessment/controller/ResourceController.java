package com.sas.assessment.controller;

import com.sas.assessment.beans.ResourceMapBean;
import com.sas.assessment.model.ResourceDetails;
import com.sas.assessment.model.ResourceResponse;
import com.sas.assessment.services.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceMapBean myOtherBean;
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<ResourceResponse> ping() {
        try{
            return new ResponseEntity(new ResourceResponse(1,"SUCCESS", Arrays.asList("Ping Successful")), HttpStatus.OK);
        } catch (Exception ex){
            logger.error("ping.Exception: ",ex);
            return new ResponseEntity(new ResourceResponse(0,ex.getMessage(), Arrays.asList("Ping Successful")), HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResourceResponse>  getAllResources() {
        try{
            ConcurrentHashMap<String,String> map = myOtherBean.getHashMap();
            return new ResponseEntity(new ResourceResponse(1, "SUCCESS", Arrays.asList(map)), HttpStatus.OK);
        } catch (Exception ex){
            logger.error("getAllResources.Exception: ",ex);
            return new ResponseEntity(new ResourceResponse(0, ex.getMessage(), Arrays.asList()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResourceResponse>  createResource( @RequestBody HashMap<String, String> body) {
        try {
            List<ResourceDetails> response_objects = resourceService.createResources(body);
            return new ResponseEntity(new ResourceResponse(1, "SUCCESS", Arrays.asList(response_objects)), HttpStatus.CREATED);

        } catch (Exception ex){
            logger.error("createResource.Exception: ",ex);
            return new ResponseEntity(new ResourceResponse(0, ex.getMessage(), Arrays.asList()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @GetMapping("/retrieve/{key}")
    public ResponseEntity getResourceByKey(@PathVariable ("key") String key) {
        try{
            ConcurrentHashMap<String,String> map = myOtherBean.getHashMap();
            if(map.containsKey(key)) {
                return new ResponseEntity(new ResourceResponse(1, "SUCCESS", Arrays.asList(map.get(key))), HttpStatus.OK);
            }
            else{
                return new ResponseEntity(new ResourceResponse(0, "Key Does not exist", Arrays.asList()), HttpStatus.OK);
            }
        } catch (Exception ex){
            logger.error("getResourceByKey.Exception: ",ex);
            return new ResponseEntity(new ResourceResponse(0, ex.getMessage(), Arrays.asList()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update")
    public ResponseEntity putResource(@RequestBody HashMap<String, String> body) {
        try {
            List<ResourceDetails> response_objects = resourceService.updateResources(body);
            return new ResponseEntity(new ResourceResponse(1, "SUCCESS", response_objects), HttpStatus.OK);
        } catch (Exception ex){
            logger.error("putResource.Exception: ",ex);
            return new ResponseEntity(new ResourceResponse(0, ex.getMessage(), Arrays.asList()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{key}")
    public ResponseEntity deleteResourceByKey(@PathVariable ("key") String key) {
        try {
            ConcurrentHashMap<String, String> map = myOtherBean.getHashMap();
            if (map.containsKey(key)) {
                map.remove(key);
                return new ResponseEntity(new ResourceResponse(1, "SUCCESS", Arrays.asList(true)), HttpStatus.OK);
            } else {
                return new ResponseEntity(new ResourceResponse(0, "Key Does not exist", Arrays.asList(false)), HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error("deleteResourceByKey.Exception: ",ex);
            return new ResponseEntity(new ResourceResponse(0, ex.getMessage(), Arrays.asList()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}