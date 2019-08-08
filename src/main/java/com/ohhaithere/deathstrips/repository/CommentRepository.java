package com.ohhaithere.deathstrips.repository;

import com.ohhaithere.deathstrips.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
