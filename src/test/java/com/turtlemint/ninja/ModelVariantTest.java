package com.turtlemint.ninja;

import com.turtlemint.ninja.common.ApiRequestBuilder;
import com.turtlemint.ninja.common.CommonFunctions;
import com.turtlemint.ninja.configurations.BasePaths;
import com.turtlemint.ninja.configurations.Services;
import com.turtlemint.ninja.pojo.VariantDetails;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ModelVariantTest {
    ApiRequestBuilder requestBuilder= ApiRequestBuilder.getInstance();
    CommonFunctions commonFunctions=CommonFunctions.getInstance();
    VariantDetails variantDetails;

    @Test
    public void getModelVariants(){
        Map<String, String> queryParams= new HashMap<>();
        queryParams.put("make","KIA");
        queryParams.put("model","SELTOS");
        queryParams.put("type","FW");
        commonFunctions.getResponseWithQueryParam(Services.MINTPRO, BasePaths.MINTPRO_MASTERS,"getVariant",queryParams);
        System.out.println(requestBuilder.response.getStatusCode());
        if(requestBuilder.response.jsonPath().getList("").size()>0){
            VariantDetails [] variantDetailsList = requestBuilder.response.as(VariantDetails[].class);

            Arrays.stream(variantDetailsList).parallel().forEach(variant -> System.out.println(variant.getDisplayVariant()));

            variantDetails = variantDetailsList[new Random().nextInt(variantDetailsList.length)];

            System.out.println("Random Variant Object: ");
            System.out.println(variantDetails.getModel());
            System.out.println(variantDetails.getMake());
            System.out.println(variantDetails.getCc());
            System.out.println(variantDetails.getFuel());
            System.out.println(variantDetails.get_id());
            System.out.println(variantDetails.getDisplayVariant());
        }else {
            System.out.println("response is empty");
        }
    }


}
