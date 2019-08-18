package com.ohhaithere.deathstrips.mapper;

import static org.junit.Assert.assertEquals;

import com.ohhaithere.deathstrips.domain.KfcRestaurant;
import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

public class KfcRestaurantMapperTest {

  MapperFactory mapperFactory;
  KfcRestaurantMapper kfcRestaurantMapper;

  @Before
  public void setUp() {
    mapperFactory = new DefaultMapperFactory.Builder().build();
    kfcRestaurantMapper = new KfcRestaurantMapper(mapperFactory);
  }

  @Test
  public void mapRestaurantToDto() {
    //given:
    KfcRestaurant restaurant = KfcRestaurant.builder().name("test").build();

    //when:
    KfcRestaurantDto kfcRestaurantDto = kfcRestaurantMapper.mapRestaurantToDto(restaurant);

    //then:
    assertEquals(kfcRestaurantDto.getName(), "test");

  }

  @Test
  public void mapDtoToRestaurantTest() {
    //given:
    KfcRestaurantDto kfcRestaurantDto = KfcRestaurantDto.builder().name("test").build();

    //when:
    KfcRestaurant restaurant = kfcRestaurantMapper.mapDtoToRestaurant(kfcRestaurantDto);

    //then:
    assertEquals(restaurant.getName(), "test");
  }

}
