package com.example.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing 
@SpringBootApplication
public class BatchApplication extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {

    }
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
	
	
	
}
