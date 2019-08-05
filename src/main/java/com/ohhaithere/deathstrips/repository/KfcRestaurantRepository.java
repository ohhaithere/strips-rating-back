package com.ohhaithere.deathstrips.repository;

import com.ohhaithere.deathstrips.domain.KfcRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KfcRestaurantRepository extends JpaRepository<KfcRestaurant, Long> {
}
