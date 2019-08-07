package com.ohhaithere.deathstrips.domain;

import javax.persistence.Id;

public class Photo {

  @Id
  String id;
  String path;
  String commentId;

}
