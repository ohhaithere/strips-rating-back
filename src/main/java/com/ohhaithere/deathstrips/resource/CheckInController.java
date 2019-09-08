package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.dto.CheckInDto;
import com.ohhaithere.deathstrips.service.CheckInService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/checkIn/")
@RequiredArgsConstructor
public class CheckInController {

  CheckInService checkInService;

  @PostMapping
  public CheckInDto saveCheckIn(@RequestBody CheckInDto checkInDto) {
    return checkInService.saveCheckIn(checkInDto);
  }

  @GetMapping("/{id}")
  public CheckInDto getCheckIn(@PathVariable String id) {
    return checkInService.getCheckIn(id);
  }

  @GetMapping
  public List<CheckInDto> getCheckIns() {
    return checkInService.getCheckIns();
  }

  @DeleteMapping
  public void deleteCheckIn(@RequestBody CheckInDto checkInDto) {
    checkInService.deleteCheckIn(checkInDto);
  }

}
