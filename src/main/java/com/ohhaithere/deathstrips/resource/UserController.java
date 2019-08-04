package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  UserDto createUser(@RequestBody UserDto user) {
    return userService.saveUser(user);
  }

}
