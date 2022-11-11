package com.example.demoC14.repository;

import com.example.demoC14.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
public User findByUserNameAndPassword(String userName, String password);

}
