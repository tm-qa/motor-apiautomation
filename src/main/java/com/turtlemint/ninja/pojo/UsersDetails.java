package com.turtlemint.ninja.pojo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDetails {
    private String username;
    private String email;
    private String name;
    private String displayName;
    private List<String> roles;
    private String mobileNo;
    private String city;
    private String allowAccess;
}
