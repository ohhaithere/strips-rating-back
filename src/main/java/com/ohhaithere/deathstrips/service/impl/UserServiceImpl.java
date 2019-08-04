package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.mapper.UserMapper;
import com.ohhaithere.deathstrips.repository.UserRepository;
import com.ohhaithere.deathstrips.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDto saveUser(UserDto user) {
    UserDto savedUser = UserMapper.mapUserToDto(userRepository.save(UserMapper.mapDtoToUser(user)));
    return savedUser;
  }

  @Override
  public Boolean deleteUser(User user) {
    userRepository.delete(user);
    return true;
  }

  @Override
  public UserDto getUser(Long id) {
    Optional<User> user = userRepository.findById(id);
    if(user.isPresent()) {
      return UserMapper.mapUserToDto(user.get());
    } else {
      return null;
    }
  }

  @Override
  public List<UserDto> getAllUsers() {
    return null;
  }


}
