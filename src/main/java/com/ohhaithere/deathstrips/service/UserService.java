package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

  UserDto saveUser(UserDto user);

  Boolean deleteUser(UserDto user);

  UserDto getUser(Long id);

  List<UserDto> getAllUsers();

}
