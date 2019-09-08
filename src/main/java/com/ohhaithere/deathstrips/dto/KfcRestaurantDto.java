package com.ohhaithere.deathstrips.dto;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KfcRestaurantDto {

  Long id;
  String name;
  String address;

}
