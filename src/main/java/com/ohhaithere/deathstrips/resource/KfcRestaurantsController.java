package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.service.KfcRestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/restaurants/")
@AllArgsConstructor
public class KfcRestaurantsController {

  private final KfcRestaurantService kfcRestaurantService;


}
