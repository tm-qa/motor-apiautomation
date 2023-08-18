package com.turtlemint.ninja.pojo;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MotorPremiumRequest {
    public int businessType;
    public String vehicleId;
    public String rtoId;
    public String rtoDesp;
    public int year;
    public String requestId;
    public String make;
    public String model;
    public String fuel;
    public String variant;
    public String customerName;
    public String policyType;
    public UtmParams utmParams;
    public String isPaid;
    public String type;
    public String userStateCode;
    public boolean initialReqFlag;
    public String vertical;
    public String clientId;
    public String dealerHash;
    public boolean unknownNCBFlag;
    public boolean expiryFlag;
    public Map<String,String> comprehensive;
    public Map<String,String>  tp;
    public Map<String,String>  od;
    public String tenant;
}
