package com.sas.assessment.beans;

import com.sas.assessment.controller.ResourceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class ResourceMapBean {
    Logger logger = LoggerFactory.getLogger(ResourceMapBean.class);
    ConcurrentHashMap<String,String> map;
    @Bean
    public void createHashMap(){
        logger.info("Creating Bean");
        map =new ConcurrentHashMap <String,String> ();
    }

    @Bean
    public ConcurrentHashMap<String, String> getHashMap(){
        logger.info("Getting hashMap");
        return map;
    }

}
