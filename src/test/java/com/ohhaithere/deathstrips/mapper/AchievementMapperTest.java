package com.ohhaithere.deathstrips.mapper;

import static org.junit.Assert.assertEquals;

import com.ohhaithere.deathstrips.domain.Achievement;
import com.ohhaithere.deathstrips.dto.AchievementDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

public class AchievementMapperTest {

  MapperFactory mapperFactory;
  AchievementMapper achievementMapper;

  @Before
  public void setUp() throws Exception {
    mapperFactory = new DefaultMapperFactory.Builder().build();
    achievementMapper = new AchievementMapper();
  }


  @Test
  public void mapAchievementToDto() {
    //given:
    Achievement achievement = Achievement.builder().name("test").build();

    //when:
    AchievementDto achievementDto = achievementMapper.mapAchievementToDto(achievement);

    //then
    assertEquals(achievementDto.getName(), "test");
  }

  @Test
  public void mapDtoToAchievement() {
    //given
    AchievementDto achievementDto = AchievementDto.builder().name("test").build();

    //when:
    Achievement achievement = achievementMapper.mapDtoToAchievement(achievementDto);

    //then:
    assertEquals(achievement.getName(), "test");
  }
}
