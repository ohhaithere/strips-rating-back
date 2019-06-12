package com.ohhaithere.deathstrips.repository;

import com.ohhaithere.deathstrips.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
