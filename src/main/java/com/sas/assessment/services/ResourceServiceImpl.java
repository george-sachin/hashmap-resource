package com.sas.assessment.services;

import com.sas.assessment.beans.ResourceMapBean;
import com.sas.assessment.model.ResourceDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapBean myOtherBean;
    private final static Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);
    public List<ResourceDetails> createResources(HashMap<String, String> body){
        try{
            ConcurrentHashMap<String,String> map = myOtherBean.getHashMap();
            List<ResourceDetails> response_objects = new ArrayList<>();
            body.forEach((key, value) -> {
                ResourceDetails response;
                if (!map.containsKey(key)) {
                    map.put(key, value);
                    response = new ResourceDetails(key, "Created resource!", true);
                } else {
                    response = new ResourceDetails(key, "Key exists. Please update existing resource!", false);
                }
                response_objects.add(response);
            });
            return response_objects;
        } catch (Exception e) {
            LOGGER.error("Exception: ",e);
            throw e;
        }
    }
    public List<ResourceDetails> updateResources(HashMap<String, String> body){
        try{
            List<ResourceDetails> response_objects = new ArrayList<>();
            ConcurrentHashMap<String,String> map = myOtherBean.getHashMap();
            body.forEach((key, value) -> {
                ResourceDetails response;
                if (map.containsKey(key)) {
                    map.put(key, value);
                    response = new ResourceDetails(key, "Updated resource!", true);
                } else {
                    response = new ResourceDetails(key, "Key does not exist. Please create resource!", false);
                }
                response_objects.add(response);
            });
            return response_objects;
        } catch (Exception e) {
            LOGGER.error("Exception: ",e);
            throw e;
        }
    }
}
