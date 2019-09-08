package com.ohhaithere.deathstrips.mapper;

import static org.junit.Assert.assertEquals;

import com.ohhaithere.deathstrips.domain.Comment;
import com.ohhaithere.deathstrips.dto.CommentDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

public class CommentsMapperTest {

  MapperFactory mapperFactory;
  CommentsMapper commentsMapper;

  @Before
  public void setUp() throws Exception {
    mapperFactory = new DefaultMapperFactory.Builder().build();
    commentsMapper = new CommentsMapper();
  }

  @Test
  public void mapCommentToDtoTest() {
    //given:
    Comment comment = Comment.builder().text("test").build();

    //when:
    CommentDto commentDto = commentsMapper.mapCommentToDto(comment);

    //then:
    assertEquals(commentDto.getText(), "test");
  }

  @Test
  public void mapDtoToCommentTest() {
    //given:
    CommentDto commentDto = CommentDto.builder().text("test").build();

    //when:
    Comment comment = commentsMapper.mapDtoToComment(commentDto);

    //then:
    assertEquals(comment.getText(), "test");
  }
}
