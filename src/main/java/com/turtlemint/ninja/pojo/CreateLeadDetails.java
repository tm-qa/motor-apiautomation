package com.turtlemint.ninja.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLeadDetails {
    public String _id;
    public String requestType;
    public boolean isAsync;
    public String vertical;
    public String userMobile;
    public String customerName;
    public String stateCode;
    public String policyType;
    public boolean initialReqFlag;
    public MotorPremiumRequest motorPremiumRequest;
    public UtmParams utmParams;
}
