package com.ohhaithere.deathstrips.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ohhaithere.deathstrips.domain.Achievement;
import com.ohhaithere.deathstrips.dto.AchievementDto;
import com.ohhaithere.deathstrips.mapper.AchievementMapper;
import com.ohhaithere.deathstrips.repository.AchievementRepository;
import com.ohhaithere.deathstrips.service.impl.AchievementServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AchievementServiceTest {

  AchievementRepository achievementRepository;
  AchievementMapper achievementMapper;
  AchievementServiceImpl achievementService;

  @Before
  public void setUp() throws Exception {
    achievementRepository = mock(AchievementRepository.class);
    achievementMapper = mock(AchievementMapper.class);
    achievementService = new AchievementServiceImpl(achievementRepository, achievementMapper);
  }

  @Test
  public void saveAchievementTest() {
    //given:
    Achievement achievement = Achievement.builder().name("test").build();
    AchievementDto achievementDto = AchievementDto.builder().name("test").build();
    when(achievementRepository.save(any(Achievement.class))).thenReturn(achievement);
    when(achievementMapper.mapAchievementToDto(any(Achievement.class))).thenReturn(achievementDto);
    when(achievementMapper.mapDtoToAchievement(any(AchievementDto.class))).thenReturn(achievement);

    //when:
    AchievementDto savedAchievement = achievementService.saveAchievement(achievementDto);

    //then:
    assertEquals(savedAchievement.getName(), "test");
  }

  @Test
  public void deleteAchievementTest() {
    //given:
    AchievementDto achievementDto = AchievementDto.builder().id(1L).build();

    //when:
    Boolean deleted = achievementService.deleteAchievement(achievementDto);

    //then:
    assertEquals(deleted, true);
  }

  @Test
  public void getAchievementTest() {
    //given:
    Achievement achievement = Achievement.builder().name("test").build();
    AchievementDto achievementDto = AchievementDto.builder().name("test").build();
    when(achievementRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(achievement));
    when(achievementMapper.mapAchievementToDto(achievement)).thenReturn(achievementDto);

    //when:
    AchievementDto foundAchievement = achievementService.getAchievement(1L);

    //then:
    assertEquals(foundAchievement.getName(), "test");
  }

  @Test
  public void notFoundAchievementTest() {
    //given:
    when(achievementRepository.findById(1L)).thenReturn(java.util.Optional.empty());

    //when:
    AchievementDto achievementDto = achievementService.getAchievement(1L);

    //then:
    assertEquals(achievementDto, null);
  }

  @Test
  public void getAchievementsTest() {
    //given:
    Achievement achievement = Achievement.builder().name("test").build();
    AchievementDto achievementDto = AchievementDto.builder().name("test").build();
    List<Achievement> achievements = new ArrayList<>();
    List<AchievementDto> achievementDtos = new ArrayList<>();
    achievements.add(achievement);
    achievementDtos.add(achievementDto);
    when(achievementRepository.findAll()).thenReturn(achievements);
    when(achievementMapper.mapAchievementToDto(any(Achievement.class))).thenReturn(achievementDto);

    //when:
    List<AchievementDto> foundAchievements = achievementService.getAchievements();

    //then
    assertEquals(foundAchievements, achievementDtos);
  }
}
