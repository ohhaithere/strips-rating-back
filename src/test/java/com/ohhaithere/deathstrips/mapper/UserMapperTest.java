package com.ohhaithere.deathstrips.mapper;

import static org.junit.Assert.assertEquals;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

public class UserMapperTest {

  MapperFactory mapperFactory;
  UserMapper userMapper;

  @Before
  public void setUp() {
    mapperFactory = new DefaultMapperFactory.Builder().build();
    userMapper = new UserMapper(mapperFactory);
  }

  @Test
  public void mapDtoToUserTest() {
    //given:
    UserDto userDto = UserDto.builder().name("test").build();

    //when:
    User user = userMapper.mapDtoToUser(userDto);

    //then:
    assertEquals(user.getName(), "test");
  }

  @Test
  public void mapUserToDtoTest() {
    //given
    User user = User.builder().name("test").build();

    //when
    UserDto userDto = userMapper.mapUserToDto(user);

    //then:
    assertEquals(userDto.getName(), "test");
  }

}
