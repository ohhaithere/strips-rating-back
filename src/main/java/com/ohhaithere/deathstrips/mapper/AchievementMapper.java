package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.Achievement;
import com.ohhaithere.deathstrips.dto.AchievementDto;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;

@RequiredArgsConstructor
public class AchievementMapper {

  private final MapperFactory mapperFactory;

  public Achievement mapDtoToAchievement(AchievementDto achievementDto) {
    BoundMapperFacade<AchievementDto, Achievement> mapperFacade = mapperFactory.getMapperFacade(AchievementDto.class, Achievement.class);
    Achievement achievement = mapperFacade.map(achievementDto);
    return achievement;
  }

  public AchievementDto mapAchievementToDto(Achievement achievement) {
    BoundMapperFacade<Achievement, AchievementDto> mapperFacade = mapperFactory.getMapperFacade(Achievement.class, AchievementDto.class);
    AchievementDto achievementDto = mapperFacade.map(achievement);
    return achievementDto;
  }

}
