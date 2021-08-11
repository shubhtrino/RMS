package com.trino.ratemanagementsystem.RMS.controller;

import com.trino.ratemanagementsystem.RMS.entity.Rate;
import com.trino.ratemanagementsystem.RMS.entity.RateVatSurchage;
import com.trino.ratemanagementsystem.RMS.exception.RMSGenericException;
import com.trino.ratemanagementsystem.RMS.service.RmsService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rms")
public class RmsController {

    @Autowired
    RmsService rmsService;

    Logger logger = LoggerFactory.getLogger(RmsController.class);

    @GetMapping("/searchRate/{id}")
    @CircuitBreaker(name="getRate",fallbackMethod = "getRateFallBack")
    public RateVatSurchage getRate(@PathVariable("id") Long id){
        logger.info("In get rate");
        return rmsService.getRateWithSurchargeDetails(id);
    }

    @PostMapping("/addRate")
    public Rate save(@Valid @RequestBody  Rate rate){
        logger.info("In add Rate ");
        return rmsService.saveRate(rate);
    }

    @PutMapping("/updateRate")
    public Rate update(@RequestBody  Rate rate){
        return rmsService.updateRate(rate);
    }

    @DeleteMapping("/deleteRate/{id}")
    public void delete(@PathVariable("id") Long id){
        Rate rate = rmsService.getRate(id);
        if(rate==null){
            throw new RMSGenericException("Rate Id Not Found In RMS", HttpStatus.NOT_FOUND);
        }
        rmsService.deleteRate(rate);
    }

    public String getRateFallBack(){
        return "Service is down please try again after some time come";
    }

}
