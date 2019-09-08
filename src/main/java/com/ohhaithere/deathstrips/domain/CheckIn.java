package com.ohhaithere.deathstrips.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {

  @Id
  String id;
  Long restaurantId;
  String description;
  String photo;
  Integer rating;
  String flavorProfile;


}
