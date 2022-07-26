package com.example.batch.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batch.model.Market;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class OtherJobConfiguration {
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	// exampleJob 생성
	@Bean
	public Job otherJob() throws Exception {
		return jobBuilderFactory.get("otherJob")
				.start(otherStep()).build();
	}
	
	// exampleStep 생성
	@Bean
	public Step otherStep() throws Exception {
		   return stepBuilderFactory.get("otherStep")
//	                .<Market, Market>chunk(10)
//	                .reader(reader(null))
//	                .processor(processor(null))
//	                .writer(writer(null))
//	                .build();				   
				   .tasklet((contribution, chunkContext) -> {
		                log.info(">>>>> otherStep started >>>>>");
		                return RepeatStatus.FINISHED;
		            })
		            .build();
		
// 		### Tasklet Example ###		   
//		return stepBuilderFactory.get("exampleStep")
//				.tasklet(new ExampleTasklet()).build();	
	}
	
//	@Bean
//    @StepScope
//    public JpaPagingItemReader<Market> reader(@Value("#{jobParameters[requestDate]}")  String requestDate) throws Exception {
//        log.info("==> reader value : " + requestDate);
//
//        Map<String, Object> parameterValues = new HashMap<>();
//        parameterValues.put("price", 1000);
//        
//        return new JpaPagingItemReaderBuilder<Market>()
//                .pageSize(10)
//                .parameterValues(parameterValues)
//                .queryString("SELECT m FROM Market m WHERE m.price >= : price")
//                .entityManagerFactory(entityManagerFactory)
//                .name("JpaPagingItemReader")
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ItemProcessor<Market, Market> processor(@Value("#{jobParameters[requestDate]}")  String requestDate){
//        return new ItemProcessor<Market, Market>() {
//            @Override
//            public Market process(Market market) throws Exception {
//
//                log.info("==> processor Market : " + market);
//                log.info("==> processor value : " + requestDate);
//
//                // 100원 추가
//                market.setPrice(market.getPrice() + 100);
//
//                return market;
//            }
//        };
//    }
//
//    @Bean
//    @StepScope
//    public JpaItemWriter<Market> writer(@Value("#{jobParameters[requestDate]}")  String requestDate){
//        log.info("==> writer value : " + requestDate);
//
//        return new JpaItemWriterBuilder<Market>()
//                .entityManagerFactory(entityManagerFactory)
//                .build();
//    }
}
