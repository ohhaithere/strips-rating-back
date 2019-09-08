package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.dto.CheckInDto;
import java.util.List;

public interface CheckInService {

  CheckInDto saveCheckIn(CheckInDto checkInDto);

  boolean deleteCheckIn(CheckInDto checkInDto);

  CheckInDto getCheckIn(String id);

  List<CheckInDto> getCheckIns();

}
