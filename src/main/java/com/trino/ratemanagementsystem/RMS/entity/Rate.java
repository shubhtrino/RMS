package com.trino.ratemanagementsystem.RMS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long rateId;

    String rateDescription;

    @NotNull
    Integer amount;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    Date rateEffectiveDate;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    Date rateExpirationDate;




}
