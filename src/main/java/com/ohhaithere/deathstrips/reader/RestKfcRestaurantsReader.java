package com.ohhaithere.deathstrips.reader;

import com.ohhaithere.deathstrips.client.KfcRestaurantsClient;
import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@RequiredArgsConstructor
public class RestKfcRestaurantsReader implements ItemReader<KfcRestaurantDto> {

  private final KfcRestaurantsClient kfcRestaurantsClient;

  private Integer nextRestaurantIndex;
  private List<KfcRestaurantDto> restaurants;


  @Override
  public KfcRestaurantDto read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    if(restaurantDataIsNotInitialized()) {
      restaurants = kfcRestaurantsClient.getRestaurants();
    }

    KfcRestaurantDto nextRestaurant = null;

    if (nextRestaurantIndex < restaurants.size()) {
      nextRestaurant = restaurants.get(nextRestaurantIndex);
      nextRestaurantIndex++;
    }

    return nextRestaurant;
  }

  private boolean restaurantDataIsNotInitialized() {
    return this.restaurants == null;
  }
}
