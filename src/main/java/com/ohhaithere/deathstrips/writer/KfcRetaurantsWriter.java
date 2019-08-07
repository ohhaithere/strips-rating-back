package com.ohhaithere.deathstrips.writer;

import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class KfcRetaurantsWriter implements ItemWriter<KfcRestaurantDto> {

  @Override
  public void write(List<? extends KfcRestaurantDto> list) throws Exception {
    log.info("Received the information of {} students", list.size());

    list.forEach(i -> log.debug("Received the information of a student: {}", i));
  }
}
