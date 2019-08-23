package com.ohhaithere.deathstrips.resource;

import static org.mockito.Mockito.mock;

import com.ohhaithere.deathstrips.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

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

  }
}
