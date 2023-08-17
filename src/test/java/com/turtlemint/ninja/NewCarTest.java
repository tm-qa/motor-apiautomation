package com.turtlemint.ninja;

import com.turtlemint.ninja.common.ApiRequestBuilder;
import com.turtlemint.ninja.common.CommonFunctions;
import com.turtlemint.ninja.configurations.BasePaths;
import com.turtlemint.ninja.configurations.Services;
import com.turtlemint.ninja.pojo.VariantDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NewCarTest {

    ApiRequestBuilder requestBuilder= ApiRequestBuilder.getInstance();
    CommonFunctions commonFunctions=CommonFunctions.getInstance();
    VariantDetails variantDetails;

    @Test
    public void verifyRedirectUrl(){
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("vertical","motor");
        queryParams.put("redirectionUrl", "car-insurance");
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization","ddfd059150bb8a29ca8ed88588fcad2d7b28f88aac00046461e6b83e24d6392c70b79489c8ffaddd90482ed53bec8f38");
        commonFunctions.getResponseWithQueryParam(Services.MINTPRO_APP, BasePaths.MINTPRO_APP_REDIRECT,"redirect",queryParams,headers);
        Assert.assertEquals(200,requestBuilder.response.getStatusCode());
    }
    @Test
    public void verifygetnewmakemodel(){
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("searchKey","KIA");
        queryParams.put("vertical", "FW");
        Map<String,String> headers = new HashMap<>();
        headers.put("accept","application/json, text/plain, */*");
        commonFunctions.getResponseWithQueryParam(Services.MINTPRO, BasePaths.MINTPRO_MASTERS_V1,"getnewmakemodel",queryParams,headers);
        Assert.assertEquals(200,requestBuilder.response.getStatusCode());
    }

    @Test
    public void verifyGetRTO(){
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("searchKey","mh");
        Map<String,String> headers = new HashMap<>();
        headers.put("accept","application/json, text/plain, */*");
        commonFunctions.getResponseWithQueryParam(Services.MINTPRO, BasePaths.MINTPRO_MASTERS,"getnewrto",queryParams,headers);
        Assert.assertEquals(200,requestBuilder.response.getStatusCode());
    }

    @Test
    public void getModelVariants(){
        Map<String, String> queryParams= new HashMap<>();
        queryParams.put("make","KIA");
        queryParams.put("model","SELTOS");
        queryParams.put("type","FW");
        commonFunctions.getResponseWithQueryParam(Services.MINTPRO, BasePaths.MINTPRO_MASTERS,"getVariant",queryParams);
//        System.out.println(requestBuilder.response.getStatusCode());
//        if(requestBuilder.response.jsonPath().getList("").size()>0){
//            VariantDetails[] variantDetailsList = requestBuilder.response.as(VariantDetails[].class);
//
//            Arrays.stream(variantDetailsList).parallel().forEach(variant -> System.out.println(variant.getDisplayVariant()));
//
//            variantDetails = variantDetailsList[new Random().nextInt(variantDetailsList.length)];
//
//            System.out.println("Random Variant Object: ");
//            System.out.println(variantDetails.getModel());
//            System.out.println(variantDetails.getMake());
//            System.out.println(variantDetails.getCc());
//            System.out.println(variantDetails.getFuel());
//            System.out.println(variantDetails.get_id());
//            System.out.println(variantDetails.getDisplayVariant());
//        }else {
//            System.out.println("response is empty");
//        }
        Assert.assertEquals(200,requestBuilder.response.getStatusCode());
    }

}
