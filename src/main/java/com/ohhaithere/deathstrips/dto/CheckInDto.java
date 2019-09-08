package com.ohhaithere.deathstrips.dto;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInDto {

  @Id
  String id;
  Long restaurantId;
  Long userId;
  String description;
  String photo;
  Integer rating;
  String flavorProfile;

}
