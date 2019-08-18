package com.ohhaithere.deathstrips.service.impl;

import com.ohhaithere.deathstrips.domain.Comment;
import com.ohhaithere.deathstrips.dto.CommentDto;
import com.ohhaithere.deathstrips.mapper.CommentsMapper;
import com.ohhaithere.deathstrips.repository.CommentRepository;
import com.ohhaithere.deathstrips.service.CommentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;
  private final CommentsMapper commentsMapper;

  @Override
  public CommentDto saveComment(CommentDto comment) {
    Comment savedComment = commentRepository.save(commentsMapper.mapDtoToComment(comment));
    return commentsMapper.mapCommentToDto(savedComment);
  }

  @Override
  public Boolean deleteComment(CommentDto comment) {
    commentRepository.delete(commentsMapper.mapDtoToComment(comment));
    return true;
  }

  @Override
  public CommentDto getComment(String id) {
    Optional<Comment> comment = commentRepository.findById(id);
    if(comment.isPresent()) {
      return commentsMapper.mapCommentToDto(comment.get());
    } else {
      return null;
    }
  }

  @Override
  public List<CommentDto> getComments() {
    List<Comment> comments = commentRepository.findAll();
    List<CommentDto> commentsToReturn = comments.stream()
        .map(comment -> commentsMapper.mapCommentToDto(comment))
        .collect(Collectors.toList());
    return commentsToReturn;
  }
}
