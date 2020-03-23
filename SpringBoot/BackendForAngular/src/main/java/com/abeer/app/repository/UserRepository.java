package com.abeer.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.abeer.app.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
