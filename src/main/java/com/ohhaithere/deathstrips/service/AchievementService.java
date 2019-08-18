package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.dto.AchievementDto;
import java.util.List;

public interface AchievementService {

  AchievementDto saveAchievement(AchievementDto achievement);

  Boolean deleteAchievement(AchievementDto achievement);

  AchievementDto getAchievement(AchievementDto achievement);

  List<AchievementDto> getAchievements();

}
