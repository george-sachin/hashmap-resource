package com.sas.assessment;

import com.sas.assessment.beans.ResourceMapBean;
import com.sas.assessment.controller.ResourceController;
import com.sas.assessment.model.ResourceDetails;
import com.sas.assessment.services.ResourceService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ResourceController.class)
//@WithMockUser
public class ResourceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResourceService studentService;

    @MockBean
    private ResourceMapBean myOtherBean;

    @Test
    public void insertResource() throws Exception {


        ResourceDetails res = new ResourceDetails("key1","Key exists. Please update existing resource!", true);
        // studentService.addCourse to respond back with mockCourse
        Mockito.when(studentService.createResources(Mockito.any(HashMap.class))).thenReturn(Arrays.asList(res));

        JSONObject json1 = new JSONObject();
        json1.put("key1","value1");

        JSONObject json2 = new JSONObject();
        json2.put("key2","value2");




        // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/resource/create")
                .accept(MediaType.APPLICATION_JSON).content(String.valueOf(json1))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());


        requestBuilder = MockMvcRequestBuilders
                .post("/resource/create")
                .accept(MediaType.APPLICATION_JSON).content(String.valueOf(json2))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result1 = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response1 = result1.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response1.getStatus());


//
//        assertEquals("http://localhost/students/Student1/courses/1",
//                response.getHeader(HttpHeaders.LOCATION));

    }

}
