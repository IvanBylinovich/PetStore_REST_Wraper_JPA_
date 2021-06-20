package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
     void deleteByUsername(String username);
     User getUserByUsername(String username);
     boolean existsByUsername(String username);

}
