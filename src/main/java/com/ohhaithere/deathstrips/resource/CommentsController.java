package com.ohhaithere.deathstrips.resource;

import com.ohhaithere.deathstrips.dto.CommentDto;
import com.ohhaithere.deathstrips.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments/")
@RequiredArgsConstructor
public class CommentsController {

  CommentService commentService;

  @PostMapping
  public CommentDto createComment(CommentDto commentDto) {
    return commentService.saveComment(commentDto);
  }

  @GetMapping
  public List<CommentDto> getAllComments() {
    return commentService.getComments();
  }

  @DeleteMapping
  public void deleteComment(CommentDto commentDto) {
    commentService.deleteComment(commentDto);
  }


}
