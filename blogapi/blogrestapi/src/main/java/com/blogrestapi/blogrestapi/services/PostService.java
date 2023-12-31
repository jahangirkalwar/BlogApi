package com.blogrestapi.blogrestapi.services;

import java.util.List;

import com.blogrestapi.blogrestapi.entities.Category;
import com.blogrestapi.blogrestapi.entities.Post;
import com.blogrestapi.blogrestapi.payloads.PostDto;

public interface PostService {

	//create
	PostDto creaPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	Post updatePost(PostDto postDto,Integer postId);
	
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	List<Post> getAllPost();
	
	
	//get single post
	Post getPostById(Integer postId);
	
	//get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);
	
	List<Post> findAllByCategory(Integer categoryId); 
}
