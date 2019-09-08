package com.ohhaithere.deathstrips.repository;

import com.ohhaithere.deathstrips.domain.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, String> {
}
