package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import java.util.List;

public interface KfcRestaurantService {

  KfcRestaurantDto saveRestaurant(KfcRestaurantDto kfcRestaurantDto);

  Boolean deleteRestaurant(KfcRestaurantDto kfcRestaurantDto);

  KfcRestaurantDto getRestaurant(Long id);

  List<KfcRestaurantDto> getRestaurants();

}
