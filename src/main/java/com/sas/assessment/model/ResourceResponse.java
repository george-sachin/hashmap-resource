package com.sas.assessment.model;
import org.springframework.lang.Nullable;

import java.util.List;

public class ResourceResponse<T> {
    private Integer responseCode;
    private String responseMessage;
    private List<T> result;
    public ResourceResponse(Integer responseCode, String responseMessage,  List<T> result) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.result = result;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
