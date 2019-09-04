package com.ohhaithere.deathstrips.resource;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.ohhaithere.deathstrips.dto.UserDto;
import com.ohhaithere.deathstrips.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public class UserControllerTest {

  private static final String USER_URL = "/user";

  private MockMvc mockMvc;
  private UserServiceImpl userService;

  @Before
  public void setUp() throws Exception {
    userService = mock(UserServiceImpl.class);
  }

  @Test
  public void getAllUsersTest() {
    //given:
    when(userService.getUser(any()))
        .thenReturn(UserDto.builder().name("test").build());

    //when:
  //  ResultActions resultActions = mockMvc.perform(get(USER_URL).
  //      .andExpect(content().string(containsString("test")));
  }
}
