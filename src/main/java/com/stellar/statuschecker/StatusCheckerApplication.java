package com.stellar.statuschecker;


import com.stellar.statuschecker.models.AggregationUnits;
import com.stellar.statuschecker.service.JSONParseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class StatusCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatusCheckerApplication.class, args);
        }
}


