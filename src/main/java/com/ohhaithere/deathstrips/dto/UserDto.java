package com.ohhaithere.deathstrips.dto;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private Long id;
  private String email;
  private String phone;
  private String name;
  private String password;

}
