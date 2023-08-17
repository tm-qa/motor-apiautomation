package com.turtlemint.ninja.common;

import com.turtlemint.ninja.configurations.BasePaths;
import com.turtlemint.ninja.configurations.Services;
import io.restassured.http.Method;

import java.util.Map;
import java.util.Objects;

public class CommonFunctions {
    ApiRequestBuilder requestBuilder = ApiRequestBuilder.getInstance();
    static CommonFunctions commonFunctions;

    public static CommonFunctions getInstance(){
        if(Objects.isNull(commonFunctions)){
            commonFunctions = new CommonFunctions();
        }
        return  commonFunctions;
    }

    public void getResponseWithQueryParam(Services service, BasePaths basePath, String endPoint, Map<String, String> queryParam){
        requestBuilder.setRequestDetails(service,basePath);
        requestBuilder.setQueryParams(queryParam);
        requestBuilder.execute(Method.GET,endPoint);
        requestBuilder.response.prettyPrint();
    }
    public void getResponseWithQueryParam(Services service, BasePaths basePath, String endPoint, Map<String, String> queryParam,Map<String,String> headers){
        requestBuilder.setRequestDetails(service,basePath);
        requestBuilder.setQueryParams(queryParam);
        requestBuilder.setHeaders(headers);
        requestBuilder.execute(Method.GET,endPoint);
        requestBuilder.response.prettyPrint();
    }
    public void getResponse(Services service, String endPoint, BasePaths basePath){
        requestBuilder.setRequestDetails(service,basePath);
        requestBuilder.execute(Method.GET,endPoint);
        requestBuilder.response.prettyPrint();
    }

    public <T> void postRequest(Services service, String endPoint, T clazz , BasePaths basePath){
        requestBuilder.setRequestDetails(service,basePath);
        requestBuilder.setRequestBody(clazz);
        requestBuilder.execute(Method.GET,endPoint);
        requestBuilder.response.prettyPrint();
    }





}
