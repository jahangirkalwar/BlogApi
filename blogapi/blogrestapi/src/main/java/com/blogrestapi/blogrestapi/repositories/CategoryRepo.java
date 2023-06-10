package com.blogrestapi.blogrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogrestapi.blogrestapi.entities.Category;
import com.blogrestapi.blogrestapi.entities.Post;

public interface CategoryRepo extends JpaRepository<Category, Integer>{ 
	List<Post> findAllByCategoryId(Integer categoryId);
}
