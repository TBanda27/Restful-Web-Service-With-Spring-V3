package com.restful_webservices.rest.user;

import com.restful_webservices.rest.helloworld.UserNotFoundException;
import com.restful_webservices.rest.helloworld.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJpaService {

    private final UserRepository userRepository;

    public UserJpaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new UserNotFoundException(String.format("User with id %d not found", id)));
    }

    public void deleteById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
    }


    public User saveUser(User user){
        userRepository.saveAndFlush(user);
        return user;
    }
}
