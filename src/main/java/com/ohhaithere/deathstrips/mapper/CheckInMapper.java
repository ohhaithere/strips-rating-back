package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.CheckIn;
import com.ohhaithere.deathstrips.dto.CheckInDto;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckInMapper {

  private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

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
