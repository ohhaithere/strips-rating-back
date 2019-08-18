package com.ohhaithere.deathstrips.service;

import com.ohhaithere.deathstrips.dto.CommentDto;
import java.util.List;

public interface CommentService {

  CommentDto saveComment(CommentDto comment);

  Boolean deleteComment(CommentDto comment);

  CommentDto getComment(String id);

  List<CommentDto> getComments();

}
