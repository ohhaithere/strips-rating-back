package com.ohhaithere.deathstrips.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ohhaithere.deathstrips.domain.Comment;
import com.ohhaithere.deathstrips.dto.CommentDto;
import com.ohhaithere.deathstrips.mapper.CommentsMapper;
import com.ohhaithere.deathstrips.repository.CommentRepository;
import com.ohhaithere.deathstrips.service.impl.CommentServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class CommentServiceTest {

  CommentRepository commentRepository;
  CommentsMapper commentsMapper;
  CommentServiceImpl commentService;

  @Before
  public void setUp() throws Exception {
    commentRepository = mock(CommentRepository.class);
    commentsMapper = mock(CommentsMapper.class);
    commentService = new CommentServiceImpl(commentRepository, commentsMapper);
  }

  @Test
  public void saveCommentTest() {
    //give:
    Comment comment = Comment.builder().text("test").build();
    CommentDto commentDto = CommentDto.builder().text("test").build();
    when(commentRepository.save(any(Comment.class))).thenReturn(comment);
    when(commentsMapper.mapCommentToDto(any(Comment.class))).thenReturn(commentDto);
    when(commentsMapper.mapDtoToComment(any(CommentDto.class))).thenReturn(comment);

    //when:
    CommentDto savedComment = commentService.saveComment(commentDto);

    //then:
    assertEquals(savedComment.getText(), "test");
  }
}
