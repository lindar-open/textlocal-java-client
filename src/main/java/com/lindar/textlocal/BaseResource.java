package com.lindar.textlocal;

import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;

import java.util.HashMap;
import java.util.Map;

class BaseResource {

    private final static String API_KEY_FIELD = "apiKey";

    protected final String apiKey;

    BaseResource(String apiKey) {
        this.apiKey = apiKey;
    }




    protected WellRestedResponse newPostRequest(String endpoint) {
        return newPostRequest(endpoint, null);
    }

    protected WellRestedResponse newPostRequest(String endpoint, Map<String, String> params){
        return WellRestedRequest.builder().url(endpoint).build().post().formParams(buildParams(params)).submit();
    }

    private Map<String, String> buildParams(Map<String, String> params){
        Map<String, String> finalParams = new HashMap<>();
        finalParams.put(API_KEY_FIELD, apiKey);

        if(params != null && !params.isEmpty()){
            finalParams.putAll(params);
        }

        return finalParams;
    }
}
