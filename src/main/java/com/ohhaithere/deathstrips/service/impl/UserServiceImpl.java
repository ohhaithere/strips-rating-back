package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.repository.UserRepository;
import com.ohhaithere.deathstrips.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
