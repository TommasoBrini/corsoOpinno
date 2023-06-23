package org.tree.javacourse.controller.response;

import com.google.gson.JsonElement;

public class HttpResponse {
    private String statusResponse;
    private JsonElement data;

    public HttpResponse(String statusResponse, JsonElement data){
        this.statusResponse = statusResponse;
        this.data = data;
    }

    public HttpResponse(String statusResponse){
        this.statusResponse = statusResponse;
    }

    public String getStatusResponse(){
        return statusResponse;
    }

    public void setStatusResponse(String statusResponse){
        this.statusResponse = statusResponse;
    }

    public JsonElement getData(){
        return data;
    }

    public void setData(JsonElement data){
        this.data = data;
    }

}
