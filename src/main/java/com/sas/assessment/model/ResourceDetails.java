package com.sas.assessment.model;

public class ResourceDetails {
    private String message;
    private boolean status;

    public ResourceDetails(String resourceKey, String message, boolean status) {
        this.resourceKey = resourceKey;
        this.message = message;
        this.status = status;
    }
    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    private String resourceKey;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
