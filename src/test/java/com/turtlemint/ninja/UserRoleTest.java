package com.turtlemint.ninja;

import com.turtlemint.ninja.common.CommonFunctions;
import com.turtlemint.ninja.configurations.Services;
import com.turtlemint.ninja.pojo.UsersDetails;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;

public class UserRoleTest {

    CommonFunctions commonFunctions;

    @BeforeClass
    public void setup() {
        commonFunctions = CommonFunctions.getInstance();
    }

    @Test
    public void updateRole() {
        UsersDetails usersDetails = UsersDetails.builder()
                .name("sayali dange")
                .email("sayali.dange@turtlemint.com")
                .username("sayali dange")
                .roles(Arrays.asList("NINJA-ADMIN", "SALES"))
                .displayName("sayali dange")
                .mobileNo("7758972163")
                .city("pune")
                .allowAccess("true").build();

        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "TmRrcFv3Bfaq5c9uxAgnZfDJrlpXWWX");
//        commonFunctions.postRequest(Services.TANGLED, "updateUserRoles", usersDetails, headers);

    }
    @Test
    public void getDpDetails() {
        Map<String, String> headers = new HashMap<>();
//        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJDIjoiYWRtaW4iLCJVSSI6IjYyZTBmZDlkNmExNDcxNjY3ZTkyODIzNiIsIkUiOiJzYXlhbGkuZGFuZ2VAdHVydGxlbWludC5jb20iLCJTSSI6Ik0iLCJpc3MiOiJ0dXJ0bGVtaW50IiwiVUEiOiJNb3ppbGxhLzUuMCAoTWFjaW50b3NoOyBJbnRlbCBNYWMgT1MgWCAxMF8xNV83KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvMTE0LjAuMC4wIFNhZmFyaS81MzcuMzYiLCJleHAiOjE2ODg4ODY0MzIsImlhdCI6MTY4ODg4MjgzMiwiUkEiOiIxMDMuMjUxLjIxMC4yMDcifQ.8XblfXz6puuWKWtuS17wzJzkPRbZ4_nFl74O-xQRpLg");
        Map<String , String> queryParams = new HashMap<>();
        queryParams.put("broker","turtlemint");
        queryParams.put("tenant","turtlemint");
        queryParams.put("skip","0");
        queryParams.put("limit","100");

//        commonFunctions.getResponseWithQueryParam(Services.AGENTPRO, "getDpDeatils", headers ,queryParams );

    }

    @Test
    public void test(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://pro.turtlemint.com/")
                .basePath("api/masters/v1/getnewmakemodel")
                .queryParam("searchKey","kia")
                .queryParam("vertical", "FW")
                .log().all()
                .get()
                .prettyPrint();
    }


}
