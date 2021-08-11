package com.trino.ratemanagementsystem.RMS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateVatSurchage {

    Long rateId;
    String rateDescription;
    Integer amount;
    Date rateEffectiveDate;
    Date rateExpirationDate;
    Integer tax;
    Integer surcharge;
}
