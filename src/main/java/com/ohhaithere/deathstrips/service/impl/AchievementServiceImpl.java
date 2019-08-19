package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.Achievement;
import com.ohhaithere.deathstrips.dto.AchievementDto;
import com.ohhaithere.deathstrips.mapper.AchievementMapper;
import com.ohhaithere.deathstrips.repository.AchievementRepository;
import com.ohhaithere.deathstrips.service.AchievementService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

  private final AchievementRepository achievementRepository;
  private final AchievementMapper achievementMapper;

  @Override
  public AchievementDto saveAchievement(AchievementDto achievement) {
    Achievement savedAchievement = achievementRepository.save(achievementMapper.mapDtoToAchievement(achievement));
    return achievementMapper.mapAchievementToDto(savedAchievement);
  }

  @Override
  public Boolean deleteAchievement(AchievementDto achievement) {
    achievementRepository.delete(achievementMapper.mapDtoToAchievement(achievement));
    return true;
  }

  @Override
  public AchievementDto getAchievement(Long id) {
    Optional<Achievement> foundAchievement = achievementRepository.findById(id);
    if(foundAchievement.isPresent()) {
      return achievementMapper.mapAchievementToDto(foundAchievement.get());
    } else {
      return null; //TODO: Add 404 exception and handler
    }
  }

  @Override
  public List<AchievementDto> getAchievements() {
    List<Achievement> achievements = achievementRepository.findAll();
    List<AchievementDto> achievementsToReturn = achievements.stream()
        .map(achievement -> achievementMapper.mapAchievementToDto(achievement))
        .collect(Collectors.toList());
    return achievementsToReturn;
  }
}
