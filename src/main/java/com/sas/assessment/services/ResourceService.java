package com.sas.assessment.services;
import com.sas.assessment.model.ResourceDetails;
import java.util.HashMap;
import java.util.List;

public interface ResourceService {

    List<ResourceDetails> createResources(HashMap<String, String> body);

    List<ResourceDetails> updateResources(HashMap<String, String> body);

}
