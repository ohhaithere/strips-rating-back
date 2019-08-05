package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.User;
import com.ohhaithere.deathstrips.dto.UserDto;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserMapper {

  private final MapperFactory mapperFactory;

  public User mapDtoToUser(UserDto userDto) {
    BoundMapperFacade<UserDto, User> mapperFacade = mapperFactory.getMapperFacade(UserDto.class, User.class);
    User user = mapperFacade.map(userDto);
    return user;
  }

  public UserDto mapUserToDto(User user) {
    BoundMapperFacade<User, UserDto> mapperFacade = mapperFactory.getMapperFacade(User.class, UserDto.class);
    UserDto userDto = mapperFacade.map(user);
    return userDto;
  }

}
