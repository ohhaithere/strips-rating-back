package com.ohhaithere.deathstrips.client;

import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class KfcRestaurantsClient {

  private static final String KFC_API_URL = "https://new-api.kfc.ru/v1/restaurants";

  public List<KfcRestaurantDto> getRestaurants() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<KfcRestaurantDto>> response = restTemplate.exchange(KFC_API_URL,
        HttpMethod.POST,
        null,
        new ParameterizedTypeReference<List<KfcRestaurantDto>>() {
        });
    return response.getBody();
  }
}
