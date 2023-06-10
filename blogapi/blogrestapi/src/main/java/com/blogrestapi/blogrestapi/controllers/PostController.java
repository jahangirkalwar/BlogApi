package com.blogrestapi.blogrestapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.blogrestapi.blogrestapi.entities.Post;

import com.blogrestapi.blogrestapi.payloads.CategoryDto;
import com.blogrestapi.blogrestapi.payloads.PostDto;
import com.blogrestapi.blogrestapi.payloads.UserDto;
import com.blogrestapi.blogrestapi.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//create 
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
											  @PathVariable Integer userId,
											  @PathVariable Integer categoryId)
	{
		PostDto createPost = this.postService.creaPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(
			@PathVariable Integer userId)
	{
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//get by category
	//@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(
			@PathVariable Integer categoryId)
	{
		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public @ResponseBody List<PostDto>  getPostsByCategoryz(
			@PathVariable Integer categoryId)
	{
		List<PostDto> posts = new ArrayList<PostDto>();
		try {
			List<Post> postList = this.postService.findAllByCategory(categoryId);
			for (Post post : postList) {
				PostDto postDto = new PostDto();
				CategoryDto categoryDto = new CategoryDto();
				categoryDto.setCategoryId(post.getCategory().getCategoryId());
				categoryDto.setCategoryTitle(post.getCategory().getCategoryTitle());
				categoryDto.setCategoryDescription(post.getCategory().getCategoryDescription());
				postDto.setCategory(categoryDto);
				UserDto userDto = new UserDto();
				userDto.setName(post.getUser().getName());
				userDto.setEmail(post.getUser().getEmail());
				userDto.setAbout(post.getUser().getAbout());
				userDto.setPassword(post.getUser().getPassword());
				userDto.setId(post.getUser().getId());
				postDto.setUser(userDto);
				postDto.setAddeDate(post.getAddedDate());
				postDto.setContent(post.getContent());
				postDto.setImageName(post.getImageName());
				postDto.setTitle(post.getTitle());
				posts.add(postDto);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return posts;
	}

}
