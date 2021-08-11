package com.trino.ratemanagementsystem.RMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VatSurcharge {
    Integer tax;
    Integer surcharge;
}
