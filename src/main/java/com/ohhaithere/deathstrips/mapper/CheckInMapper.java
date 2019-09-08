package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.CheckIn;
import com.ohhaithere.deathstrips.dto.CheckInDto;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;

@RequiredArgsConstructor
public class CheckInMapper {

  private final MapperFactory mapperFactory;

  public CheckIn mapDtoToCheckIn(CheckInDto dto) {
    BoundMapperFacade<CheckInDto, CheckIn> mapperFacade = mapperFactory.getMapperFacade(CheckInDto.class, CheckIn.class);
    CheckIn checkIn = mapperFacade.map(dto);
    return checkIn;
  }

  public CheckInDto mapCheckInToDto(CheckIn checkIn) {
    BoundMapperFacade<CheckIn, CheckInDto> mapperFacade = mapperFactory.getMapperFacade(CheckIn.class, CheckInDto.class);
    CheckInDto dto = mapperFacade.map(checkIn);
    return dto;
  }
}
