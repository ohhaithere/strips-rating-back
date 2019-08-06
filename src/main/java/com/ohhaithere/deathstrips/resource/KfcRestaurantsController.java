package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import com.ohhaithere.deathstrips.service.KfcRestaurantService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/restaurants/")
@AllArgsConstructor
public class KfcRestaurantsController {

  private final KfcRestaurantService kfcRestaurantService;

  public KfcRestaurantDto getRestoraunt(@RequestParam Long id) {
    return kfcRestaurantService.getRestaurant(id);
  }

  public List<KfcRestaurantDto> getRestaurants() {
    return kfcRestaurantService.getRestaurants();
  }

}
