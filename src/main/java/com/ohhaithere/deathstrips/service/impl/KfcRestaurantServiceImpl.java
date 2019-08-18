package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.KfcRestaurant;
import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import com.ohhaithere.deathstrips.mapper.KfcRestaurantMapper;
import com.ohhaithere.deathstrips.repository.KfcRestaurantRepository;
import com.ohhaithere.deathstrips.service.KfcRestaurantService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KfcRestaurantServiceImpl implements KfcRestaurantService {

  private final KfcRestaurantRepository kfcRestaurantRepository;
  private final KfcRestaurantMapper kfcRestaurantMapper;


  @Override
  public KfcRestaurantDto saveRestaurant(KfcRestaurantDto kfcRestaurantDto) {
    KfcRestaurantDto kfcRestaurantSaved = kfcRestaurantMapper.
        mapRestaurantToDto(kfcRestaurantRepository.save(kfcRestaurantMapper.mapDtoToRestaurant(kfcRestaurantDto)));
    return kfcRestaurantSaved;
  }

  @Override
  public Boolean deleteRestaurant(KfcRestaurantDto kfcRestaurantDto) {
    KfcRestaurant restaurant = kfcRestaurantMapper.mapDtoToRestaurant(kfcRestaurantDto);
    kfcRestaurantRepository.delete(restaurant);
    return true;
  }

  @Override
  public KfcRestaurantDto getRestaurant(Long id) {
    Optional<KfcRestaurant> restaurant = kfcRestaurantRepository.findById(id);
    if(restaurant.isPresent()) {
      return kfcRestaurantMapper.mapRestaurantToDto(restaurant.get());
    } else {
      return null; //TODO: Add 404 exception and handler
    }
  }

  @Override
  public List<KfcRestaurantDto> getRestaurants() {
    List<KfcRestaurant> restaurants = kfcRestaurantRepository.findAll();
    List<KfcRestaurantDto> restaurantDtos = restaurants.stream()
        .map(restaurant -> kfcRestaurantMapper.mapRestaurantToDto(restaurant))
        .collect(Collectors.toList());
    return restaurantDtos;
  }
}
