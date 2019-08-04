package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;

@AllArgsConstructor
public class UserMapper {

  private static MapperFactory mapperFactory;

  public static User mapDtoToUser(UserDto userDto) {
    BoundMapperFacade<UserDto, User> mapperFacade = mapperFactory.getMapperFacade(UserDto.class, User.class);
    User user = mapperFacade.map(userDto);
    return user;
  }

  public static UserDto mapUserToDto(User user) {
    BoundMapperFacade<User, UserDto> mapperFacade = mapperFactory.getMapperFacade(User.class, UserDto.class);
    UserDto userDto = mapperFacade.map(user);
    return userDto;
  }

}
