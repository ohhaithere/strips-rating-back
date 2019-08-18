package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.mapper.UserMapper;
import com.ohhaithere.deathstrips.repository.UserRepository;
import com.ohhaithere.deathstrips.service.UserService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserDto saveUser(UserDto user) {
    UserDto savedUser = userMapper.mapUserToDto(userRepository.save(userMapper.mapDtoToUser(user)));
    return savedUser;
  }

  @Override
  public Boolean deleteUser(UserDto user) {
    userRepository.delete(userMapper.mapDtoToUser(user));
    return true;
  }

  @Override
  public UserDto getUser(Long id) {
    Optional<User> user = userRepository.findById(id);
    if(user.isPresent()) {
      return userMapper.mapUserToDto(user.get());
    } else {
      return null; //TODO: Add 404 exception and handler
    }
  }

  @Override
  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();
    List<UserDto> userDtos = users.stream()
        .map(user -> userMapper.mapUserToDto(user))
        .collect(Collectors.toList());
    return userDtos;
  }


}
