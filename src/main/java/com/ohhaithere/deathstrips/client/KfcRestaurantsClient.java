package com.ohhaithere.deathstrips.client;

import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import java.util.List;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KfcRestaurantsClient {

  private static final String KFC_API_URL = "https://new-api.kfc.ru/v1/restaurants";

  public List<KfcRestaurantDto> getRestaurants() {
    CloseableHttpClient httpClient =
        HttpClients.custom()
            .setSSLHostnameVerifier(new NoopHostnameVerifier())
            .build();
    HttpComponentsClientHttpRequestFactory reqFactory =
        new HttpComponentsClientHttpRequestFactory();
    reqFactory.setHttpClient(httpClient);

    RestTemplate restTemplate = new RestTemplate(reqFactory);
    HttpEntity<String> request = new HttpEntity<String>("parameters", getHeaders());
    ResponseEntity<List<KfcRestaurantDto>> response = restTemplate.exchange(KFC_API_URL,
        HttpMethod.POST,
        request,
        new ParameterizedTypeReference<List<KfcRestaurantDto>>() {
        });
    return response.getBody();
  }

  public HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-current-website", "ru");
    headers.set("X-current-lang", "ru");
    return headers;
  }
}
