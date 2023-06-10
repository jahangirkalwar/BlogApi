package com.blogrestapi.blogrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogrestapi.blogrestapi.entities.Category;
import com.blogrestapi.blogrestapi.entities.Post;
import com.blogrestapi.blogrestapi.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findAllByCategory_CategoryId(Integer categoryId);
      
}
