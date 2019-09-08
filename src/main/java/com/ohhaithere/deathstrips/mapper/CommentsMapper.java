package com.ohhaithere.deathstrips.mapper;

import com.ohhaithere.deathstrips.domain.Comment;
import com.ohhaithere.deathstrips.dto.CommentDto;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

@Service
public class CommentsMapper {

  private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

  public Comment mapDtoToComment(CommentDto commentDto) {
    BoundMapperFacade<CommentDto, Comment> mapperFacade = mapperFactory.getMapperFacade(CommentDto.class, Comment.class);
    Comment comment = mapperFacade.map(commentDto);
    return comment;
  }

  public CommentDto mapCommentToDto(Comment comment) {
    BoundMapperFacade<Comment, CommentDto> mapperFacade = mapperFactory.getMapperFacade(Comment.class, CommentDto.class);
    CommentDto commentDto = mapperFacade.map(comment);
    return commentDto;
  }

}
