package com.ohhaithere.deathstrips.repository;

import com.ohhaithere.deathstrips.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
}
