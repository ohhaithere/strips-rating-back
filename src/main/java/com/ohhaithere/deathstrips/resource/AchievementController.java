package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.dto.AchievementDto;
import com.ohhaithere.deathstrips.service.AchievementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achievement/")
@RequiredArgsConstructor
public class AchievementController {

  AchievementService achievementService;

  @PostMapping
  public AchievementDto createAchievement(AchievementDto achievementDto) {
    return achievementService.saveAchievement(achievementDto);
  }

  @GetMapping("/{id}")
  public AchievementDto getAchevement(@RequestParam Long id) {
    return achievementService.getAchievement(id);
  }

  @GetMapping
  public List<AchievementDto> getAchievements() {
    return achievementService.getAchievements();
  }

  @DeleteMapping
  public void deleteAchievement(AchievementDto achievementDto) {
    achievementService.deleteAchievement(achievementDto);
  }

}
