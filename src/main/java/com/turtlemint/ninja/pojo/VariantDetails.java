package com.turtlemint.ninja.pojo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariantDetails {
    private String _id;
    private String make;
    private String model;
    private String fuel;
    private int cc;
    private String displayVariant;
    private Boolean isActive;
    private String variant;

}
