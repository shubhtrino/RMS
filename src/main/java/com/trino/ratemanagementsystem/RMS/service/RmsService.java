package com.trino.ratemanagementsystem.RMS.service;

import com.trino.ratemanagementsystem.RMS.entity.Rate;
import com.trino.ratemanagementsystem.RMS.entity.RateVatSurchage;
import com.trino.ratemanagementsystem.RMS.entity.VatSurcharge;
import com.trino.ratemanagementsystem.RMS.exception.RMSGenericException;
import com.trino.ratemanagementsystem.RMS.repository.RmsRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RmsService {

    @Autowired
    RmsRepo rmsRepo;

    @Autowired
    WebClient webClient;

    public static final String BASE_URL="https://surcharge.free.beeceptor.com/surcharge";

    public RateVatSurchage getRateWithSurchargeDetails(Long id){
        Rate rate = rmsRepo.findByRateId(id);
        if(rate==null){
            throw new RMSGenericException("Rate Id Not Found In RMS", HttpStatus.NOT_FOUND);
        }

        VatSurcharge vat =getVatSurCharge();
        RateVatSurchage rateVatSurchage = new RateVatSurchage();
        rateVatSurchage.setRateId(rate.getRateId());
        rateVatSurchage.setRateDescription(rate.getRateDescription());
        rateVatSurchage.setAmount(rate.getAmount());
        rateVatSurchage.setRateEffectiveDate(rate.getRateEffectiveDate());
        rateVatSurchage.setRateExpirationDate(rate.getRateExpirationDate());
        rateVatSurchage.setSurcharge(vat.getSurcharge());
        rateVatSurchage.setTax(vat.getTax());
        return rateVatSurchage;
    }

    public  Rate getRate(Long id){
        return rmsRepo.findByRateId(id);
    }

    public Rate saveRate(Rate rate){
        Rate newRate =null;
        try{
            newRate= rmsRepo.save(rate);
        }catch( Exception e){
            throw new RuntimeException();
        }
        return newRate;
    }

    public Rate updateRate(Rate rate){
        Rate newRate =null;
        try{
            newRate= rmsRepo.save(rate);
        }catch( Exception e){
            throw new RuntimeException();
        }
        return newRate;
    }

    public  void deleteRate(Rate rate){
        rmsRepo.delete(rate);
    }

    @CircuitBreaker(name="getVatSurCharge", fallbackMethod = "getVatSurChargeFallBack")
    public VatSurcharge getVatSurCharge()
    {
        return webClient.get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToMono(VatSurcharge.class)
                .block();
    }

    public String getVatSurChargeFallBack(){
        return "Service is down please try again after some time come";
    }
}
