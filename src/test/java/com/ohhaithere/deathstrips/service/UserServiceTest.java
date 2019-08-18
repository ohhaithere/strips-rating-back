package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.mapper.UserMapper;
import com.ohhaithere.deathstrips.repository.UserRepository;
import com.ohhaithere.deathstrips.service.impl.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;
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
  public void saveUserTest() {
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
  public void notFoundUserTest() {
    //given:
    when(userRepository.findById(any(Long.class)))
        .thenReturn(java.util.Optional.empty());

    //when
    UserDto notFoundUser = userService.getUser(1L);

    //then:
    assertEquals(notFoundUser, null);
  }

  @Test
  public void deleteUserTest() {
    //given:
    UserDto user = UserDto.builder().id(1L).build();

    //when:
    boolean deleted = userService.deleteUser(user);

    //then:
    assertEquals(deleted, true);
  }

  @Test
  public void getAllUsersTest() {
    //given
    User user = User.builder().name("test").build();
    UserDto userDto = UserDto.builder().name("test").build();
    List<User> users = new ArrayList<>();
    List<UserDto> usersDto = new ArrayList<>();
    users.add(user);
    usersDto.add(userDto);
    when(userRepository.findAll()).thenReturn(users);
    when(userMapper.mapUserToDto(any(User.class))).thenReturn(userDto);

    //when:
    List<UserDto> allUsers = userService.getAllUsers();

    //then
    assertEquals(allUsers, usersDto);
  }
}
