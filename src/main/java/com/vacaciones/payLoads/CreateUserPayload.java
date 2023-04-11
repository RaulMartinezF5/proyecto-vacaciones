package com.vacaciones.payLoads;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserPayload {

    private String document;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Integer holyDays;
    private String position;
    private String userType;
    private String location;
    private Date singInDate;
    private Date withdrawalDate;

}
