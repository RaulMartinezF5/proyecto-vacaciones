package com.vacaciones.payLoads;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateRequestPayload {
    
    private String issue;
    private String state;
    private Date startDate;
    private Date endDate;
    private String nameTypeOfRequest;
    private String descriptionCauseRequest;
    private Integer quantityOfDays;
}
