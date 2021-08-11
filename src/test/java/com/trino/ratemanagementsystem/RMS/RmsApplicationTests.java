package com.trino.ratemanagementsystem.RMS;

import com.trino.ratemanagementsystem.RMS.entity.Rate;
import com.trino.ratemanagementsystem.RMS.entity.VatSurcharge;
import com.trino.ratemanagementsystem.RMS.repository.RmsRepo;
import com.trino.ratemanagementsystem.RMS.service.RmsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RmsApplicationTests {

	@Autowired
	private RmsService rmsService;

	@MockBean
	private RmsRepo rmsRepo;


	@Test
	public void getSurcharge(){

		VatSurcharge vatSurcharge = new VatSurcharge(50,250);

		assertEquals(vatSurcharge.getTax(),rmsService.getVatSurCharge().getTax());
		assertEquals(vatSurcharge.getSurcharge(),rmsService.getVatSurCharge().getSurcharge());

	}

	@Test
	void saveRate(){
		Rate rate = new Rate(1L,"",100,new Date(),new Date());
		when(rmsRepo.save(rate)).thenReturn(rate);
		assertEquals(rate,rmsService.saveRate(rate));
	}

	@Test
	void getRate(){
		Rate rate = new Rate(1L,"",100,new Date(),new Date());
		when(rmsRepo.findByRateId(1L)).thenReturn(rate);
		assertEquals(rate,rmsService.getRate(1L));
	}


	@Test
	void deleteRate(){
		Rate rate = new Rate(1L,"",100,new Date(),new Date());
		rmsService.deleteRate(rate);
		verify(rmsRepo,times(1)).delete(rate);
	}
}
