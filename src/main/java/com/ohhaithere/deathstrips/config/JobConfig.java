package com.ohhaithere.deathstrips.config;

import com.ohhaithere.deathstrips.client.KfcRestaurantsClient;
import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import com.ohhaithere.deathstrips.reader.RestKfcRestaurantsReader;
import com.ohhaithere.deathstrips.writer.KfcRetaurantsWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

  @Bean
  ItemReader<KfcRestaurantDto> restRestaurantsReader(KfcRestaurantsClient client) {
      return new RestKfcRestaurantsReader(client);
  }

  @Bean
  ItemWriter<KfcRestaurantDto> restRestaurantsWriter() {
    return new KfcRetaurantsWriter();
  }

  @Bean
  Step restRestaurantsStep(ItemReader<KfcRestaurantDto> restRestaurantReader,
      ItemWriter<KfcRestaurantDto> restRestaurantWriter,
      StepBuilderFactory stepBuilderFactory) {
    return stepBuilderFactory.get("restRestaurantsStep")
        .<KfcRestaurantDto, KfcRestaurantDto>chunk(1)
        .reader(restRestaurantReader)
        .writer(restRestaurantWriter)
        .build();
  }

  @Bean
  Job restRestaurantsJob(JobBuilderFactory jobBuilderFactory,
      @Qualifier("restRestaurantsStep") Step restRestaurantsStep) {
    return jobBuilderFactory.get("restRestaurantsJob")
        .incrementer(new RunIdIncrementer())
        .flow(restRestaurantsStep)
        .end()
        .build();
  }

}
