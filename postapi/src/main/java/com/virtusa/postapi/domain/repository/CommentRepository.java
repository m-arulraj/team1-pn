package com.virtusa.postapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.postapi.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {

	@Modifying
	@Query("update Comment c set c.message =:message where c.id =:id")
	int editCommentMessage(@Param("id")Long id,@Param("message")String message);
	
	@Query("select c from Comment c where c.postId =:postId")
	List<Comment> getAllCommentInPost (@Param("postId") Long postId);
}
