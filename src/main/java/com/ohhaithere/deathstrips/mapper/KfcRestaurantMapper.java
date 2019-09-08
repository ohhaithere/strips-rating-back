package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.KfcRestaurant;
import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

@Service
public class KfcRestaurantMapper {

  private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

  public KfcRestaurant mapDtoToRestaurant(KfcRestaurantDto kfcRestaurantDto) {
    BoundMapperFacade<KfcRestaurantDto, KfcRestaurant> mapperFacade = mapperFactory.getMapperFacade(KfcRestaurantDto.class, KfcRestaurant.class);
    KfcRestaurant kfcRestaurant = mapperFacade.map(kfcRestaurantDto);
    return kfcRestaurant;
  }

  public KfcRestaurantDto mapRestaurantToDto(KfcRestaurant kfcRestaurant) {
    BoundMapperFacade<KfcRestaurant, KfcRestaurantDto> mapperFacade = mapperFactory.getMapperFacade(KfcRestaurant.class, KfcRestaurantDto.class);
    KfcRestaurantDto kfcRestaurantDto = mapperFacade.map(kfcRestaurant);
    return kfcRestaurantDto;
  }

}
