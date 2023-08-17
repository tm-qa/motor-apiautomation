package com.turtlemint.ninja.common;

import com.turtlemint.ninja.configurations.BasePaths;
import com.turtlemint.ninja.configurations.PropertyHandler;
import com.turtlemint.ninja.configurations.Services;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class ApiRequestBuilder {

    RequestSpecification requestSpecification= given();
    public Response response;
    RequestSpecBuilder requestSpecBuilder;
    static ApiRequestBuilder apiRequestBuilder;

    /** Create an instance of ApiRequestBuilder class * */
    public static ApiRequestBuilder getInstance(){
        if(Objects.isNull(apiRequestBuilder)){
            apiRequestBuilder = new ApiRequestBuilder();
        }
        return apiRequestBuilder;
    }

    public void setRequestDetails(Services service, BasePaths basePath){
        requestSpecBuilder= new RequestSpecBuilder();
        requestSpecification=requestSpecBuilder.setBaseUri(System.getProperty(service.getService()))
                .setBasePath(basePath.getBasePath())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build().log().all();
    }

    public void execute(Method method, String endpoint){
        switch (method){
            case GET:
                response= given().spec(requestSpecification).get(getEndPoint(endpoint));
                break;
            case POST:
                response= given().spec(requestSpecification).post(getEndPoint(endpoint));
                break;
            case PUT:
                response= given().spec(requestSpecification).put(getEndPoint(endpoint));
                break;
            case PATCH:
                response= given().spec(requestSpecification).patch(getEndPoint(endpoint));
                break;
            case DELETE:
                response= given().spec(requestSpecification).delete(getEndPoint(endpoint));
        }
    }

    public String getEndPoint(String endpoint){
        PropertyHandler property= new PropertyHandler("endpoints.properties");
        try {
            return  property.getProperty(endpoint);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /** Set Query param in request specification
     * @param queryParams
     *
     * */
    public void setQueryParams(Map<String,String> queryParams){
         requestSpecification.queryParams(queryParams);
    }

    public void setPathParam(String pathParam){
      requestSpecification.pathParam("pathParam", pathParam);
    }

    public void setRequestBody(Object clazz){
        if(Objects.nonNull(clazz)){
            requestSpecification.body(clazz.toString());
        }
    }

    public void setHeaders(Map<String, String> headers){
        Optional.ofNullable(headers).ifPresent(requestSpecification::headers);
    }

}
