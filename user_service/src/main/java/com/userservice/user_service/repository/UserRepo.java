package com.userservice.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.user_service.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
