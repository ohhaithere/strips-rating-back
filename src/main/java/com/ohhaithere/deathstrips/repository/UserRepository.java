package com.ohhaithere.deathstrips.repository;

import com.ohhaithere.deathstrips.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
