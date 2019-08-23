package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public UserDto createUser(@RequestBody UserDto user) {
    return userService.saveUser(user);
  }

  @GetMapping("/{id}")
  public UserDto getUser(@PathVariable Long id) {
    return userService.getUser(id);
  }

  @GetMapping
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

  @PutMapping
  public UserDto updateUser(@RequestBody UserDto user) {
    return userService.saveUser(user);
  }


}
