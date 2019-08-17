package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.mapper.UserMapper;
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
  UserMapper userMapper;
  UserService userService;

  @Before
  public void setUp() {
    userRepository = mock(UserRepository.class);
    userMapper = mock(UserMapper.class);

    User userToReturn = User.builder()
        .name("test")
        .build();

    when(userRepository.save(any(User.class))).thenReturn(userToReturn);

    when(userMapper.mapUserToDto(any(User.class))).thenReturn(UserDto.builder()
        .name("test")
        .build());

    when(userMapper.mapDtoToUser(any(UserDto.class))).thenReturn(userToReturn);
    userService = new UserServiceImpl(userRepository, userMapper);
  }

  @Test
  public void addUserTest() {
    //given:
    UserDto user = UserDto.builder()
            .name("test")
            .build();
    //when:
    UserDto savedUser = userService.saveUser(user);

    //then:
    assertEquals(savedUser.getName(), user.getName());
  }

  @Test
  public void getUserTest() {
    //given:
    when(userRepository.findById(any(Long.class)))
            .thenReturn(java.util.Optional.ofNullable(User.builder()
                    .name("test").build()));
    when(userMapper.mapUserToDto(any(User.class))).thenReturn(UserDto.builder()
        .name("test")
        .build());

    //when:
    UserDto foudnUser = userService.getUser(1L);

    //then:
    assertEquals(foudnUser.getName(), "test");
  }

  @Test
  public void deleteUserTest() {
    //given:
    when()
  }



}
