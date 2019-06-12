package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.repository.UserRepository;
import com.ohhaithere.deathstrips.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

  UserRepository userRepository;
  UserService userService;

  @Before
  public void setUp() {
    userRepository = mock(UserRepository.class);
    when(userRepository.save(any(User.class))).thenReturn(User.builder()
            .name("test")
            .build());
    userService = new UserServiceImpl(userRepository);
  }

  @Test
  public void add_user_test() {
    //given:
    User user = User.builder()
            .name("test")
            .build();
    //when:
    User savedUser = userService.saveUser(user);

    //then:
    assertEquals(savedUser.getName(), user.getName());
  }

}
