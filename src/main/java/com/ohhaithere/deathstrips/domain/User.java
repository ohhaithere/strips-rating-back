package com.ohhaithere.deathstrips.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String email;
  private String phone;
  private String name;
  private String password;


}
