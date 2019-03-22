package com.virtusa.postapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="post_date")
	private String date;
	
	@Column(name="img")
	private String image;
	
	@Column(name="message")
	private String message;
	
	@Column(name="likes")
	private Long likes;
	

	@Column(name="user_id")
	private long userId;

	

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
}
