package com.blogrestapi.blogrestapi.services.Impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.loader.custom.CollectionFetchReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogrestapi.blogrestapi.entities.Category;
import com.blogrestapi.blogrestapi.entities.Post;
import com.blogrestapi.blogrestapi.entities.User;
import com.blogrestapi.blogrestapi.exceptions.ResourceNotFoundException;
import com.blogrestapi.blogrestapi.payloads.PostDto;
import com.blogrestapi.blogrestapi.repositories.CategoryRepo;
import com.blogrestapi.blogrestapi.repositories.PostRepo;
import com.blogrestapi.blogrestapi.repositories.UserRepo;
import com.blogrestapi.blogrestapi.services.PostService;

import net.bytebuddy.asm.Advice.This;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public PostDto creaPost(PostDto postDto,Integer userId, Integer categoryId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
		Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		
		Post post = this.modelMapper.map(postDto,Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post updatedPost = this.postRepo.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category category= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}
	
	

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User Id",userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAllByCategory(Integer categoryId) {
		List<Post> posts = postRepo.findAllByCategory_CategoryId(categoryId);
		return posts;
	}

}
