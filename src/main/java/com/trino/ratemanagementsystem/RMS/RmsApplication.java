package com.trino.ratemanagementsystem.RMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RmsApplication {
	//private static final Logger LOGGER  = LoggerFactory.getLogger( "sizeAndTimeBased" );

	public static void main(String[] args) {

		//added to check rollover
		/*for ( int i = 1; i <= 40; i++ ) {
			LOGGER.info( "write log with SizeAndTimeBasedFNATP" );
			try {
				Thread.sleep( 1000L );
			} catch ( final InterruptedException e ) {
				LOGGER.error( "an error occurred", e );
			}
		}*/
		SpringApplication.run(RmsApplication.class, args);
	}

}
