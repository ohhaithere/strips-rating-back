package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

  UserDto saveUser(UserDto user);

  Boolean deleteUser(User user);

  UserDto getUser(Long id);

  List<UserDto> getAllUsers();

}
