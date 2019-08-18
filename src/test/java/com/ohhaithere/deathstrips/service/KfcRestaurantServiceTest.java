package com.ohhaithere.deathstrips.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ohhaithere.deathstrips.domain.KfcRestaurant;
import com.ohhaithere.deathstrips.dto.KfcRestaurantDto;
import com.ohhaithere.deathstrips.mapper.KfcRestaurantMapper;
import com.ohhaithere.deathstrips.repository.KfcRestaurantRepository;
import com.ohhaithere.deathstrips.service.impl.KfcRestaurantServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class KfcRestaurantServiceTest {

  KfcRestaurantRepository kfcRestaurantRepository;
  KfcRestaurantMapper kfcRestaurantMapper;
  KfcRestaurantServiceImpl kfcRestaurantService;

  @Before
  public void setUp() {
    kfcRestaurantRepository = mock(KfcRestaurantRepository.class);
    kfcRestaurantMapper = mock(KfcRestaurantMapper.class);
    kfcRestaurantService = new KfcRestaurantServiceImpl(kfcRestaurantRepository, kfcRestaurantMapper);
  }

  @Test
  public void saveRestaurantTest() {
    //given:
    KfcRestaurant restaurant = KfcRestaurant.builder()
        .name("test").build();
    KfcRestaurantDto restaurantToReturn = KfcRestaurantDto.builder()
        .name("test").build();

    when(kfcRestaurantRepository.save(any(KfcRestaurant.class))).thenReturn(restaurant);
    when(kfcRestaurantMapper.mapDtoToRestaurant(any(KfcRestaurantDto.class))).thenReturn(restaurant);
    when(kfcRestaurantMapper.mapRestaurantToDto(any(KfcRestaurant.class))).thenReturn(restaurantToReturn);

    //when:
    KfcRestaurantDto savedRestaurant = kfcRestaurantService.saveRestaurant(restaurantToReturn);

    //then
    assertEquals(savedRestaurant, restaurantToReturn);
  }

  @Test
  public void deleteRestaurantTest() {
    //given
    KfcRestaurantDto restaurantToDelete = KfcRestaurantDto.builder()
        .id(1L).build();

    //when:
    boolean deleted = kfcRestaurantService.deleteRestaurant(restaurantToDelete);

    //then:

    assertEquals(deleted, true);
  }

  @Test
  public void getRestaurantTest() {
    //given:
    KfcRestaurant restaurant = KfcRestaurant.builder().name("test").build();
    KfcRestaurantDto restaurantToReturn = KfcRestaurantDto.builder().name("test").build();
    when(kfcRestaurantRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(restaurant));
    when(kfcRestaurantMapper.mapRestaurantToDto(any(KfcRestaurant.class))).thenReturn(restaurantToReturn);

    //when:
    KfcRestaurantDto foundRestaurant = kfcRestaurantService.getRestaurant(1L);

    //then:
    assertEquals(foundRestaurant, restaurantToReturn);
  }

  @Test
  public void notFoundRestaurantTest() {
    //given:
    when(kfcRestaurantRepository.findById(1L)).thenReturn(java.util.Optional.empty());

    //when:
    KfcRestaurantDto restauranToReturn = kfcRestaurantService.getRestaurant(1L);

    //then:
    assertEquals(restauranToReturn, null);
  }

  @Test
  public void getAllRestaurantsTest() {
    //given:
    KfcRestaurant restaurant = KfcRestaurant.builder().name("test").build();
    KfcRestaurantDto restaurantToReturn = KfcRestaurantDto.builder().name("test").build();
    List<KfcRestaurant> restaurans = new ArrayList<>();
    List<KfcRestaurantDto> restaurantsToReturn = new ArrayList<>();
    restaurans.add(restaurant);
    restaurantsToReturn.add(restaurantToReturn);
    when(kfcRestaurantRepository.findAll()).thenReturn(restaurans);
    when(kfcRestaurantMapper.mapRestaurantToDto(any(KfcRestaurant.class))).thenReturn(restaurantToReturn);

    //when:
    List<KfcRestaurantDto> foundRestaurants = kfcRestaurantService.getRestaurants();

    //then:
    assertEquals(foundRestaurants, restaurantsToReturn);
  }

}
