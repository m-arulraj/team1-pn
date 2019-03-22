package com.virtusa.postapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.postapi.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
