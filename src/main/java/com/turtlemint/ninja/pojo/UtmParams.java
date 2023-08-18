package com.turtlemint.ninja.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtmParams {
    public String utmSource;
    public String utmMedium;
    public String utmUrl;
}
