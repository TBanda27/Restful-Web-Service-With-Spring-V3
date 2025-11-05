package com.restful_webservices.rest.helloworld;

import com.restful_webservices.rest.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
