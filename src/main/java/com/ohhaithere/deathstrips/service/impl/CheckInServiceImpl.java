package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.CheckIn;
import com.ohhaithere.deathstrips.dto.CheckInDto;
import com.ohhaithere.deathstrips.mapper.CheckInMapper;
import com.ohhaithere.deathstrips.repository.CheckInRepository;
import com.ohhaithere.deathstrips.service.CheckInService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckInServiceImpl implements CheckInService {

  CheckInRepository checkInRepository;
  CheckInMapper checkInMapper;


  @Override
  public CheckInDto saveCheckIn(CheckInDto checkInDto) {
    CheckIn savedCheckIn = checkInRepository.save(checkInMapper.mapDtoToCheckIn(checkInDto));
    return checkInMapper.mapCheckInToDto(savedCheckIn);
  }

  @Override
  public boolean deleteCheckIn(CheckInDto checkInDto) {
    checkInRepository.delete(checkInMapper.mapDtoToCheckIn(checkInDto));
    return true;
  }

  @Override
  public CheckInDto getCheckIn(String id) {
    Optional<CheckIn> foundCheckIn = checkInRepository.findById(id);
    if(foundCheckIn.isPresent()) {
      return checkInMapper.mapCheckInToDto(foundCheckIn.get());
    } else {
      return null;
    }
  }

  @Override
  public List<CheckInDto> getCheckIns() {
    List<CheckIn> checkIns = checkInRepository.findAll();
    List<CheckInDto> checkInDtos = checkIns.stream()
        .map(checkIn -> checkInMapper.mapCheckInToDto(checkIn))
        .collect(Collectors.toList());
    return checkInDtos;
  }
}
