package com.blogrestapi.blogrestapi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name = "post_title" ,length = 100,nullable= false)
	private String title;
	
	@Column(name="post_content",length = 1000)
	private String content;
	
	@Column(name = "image_name")
	private String imageName;
	
	private Date addedDate;
	
	@ManyToOne
	//@JsonBackReference
	@JsonIgnore
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne 
	//@JsonBackReference
	@JsonIgnore
	private User user;
}
