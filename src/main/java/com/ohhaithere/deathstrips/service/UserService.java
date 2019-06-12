package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  User saveUser(User user);

}
