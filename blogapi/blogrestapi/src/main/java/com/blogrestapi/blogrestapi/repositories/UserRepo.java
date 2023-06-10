package com.blogrestapi.blogrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogrestapi.blogrestapi.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
         
}
