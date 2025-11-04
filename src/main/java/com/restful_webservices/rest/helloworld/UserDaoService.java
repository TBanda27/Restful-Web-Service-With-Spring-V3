package com.restful_webservices.rest.helloworld;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<User>();

    private static int count = 0;

    static{
        users.add(new User(++count, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "Adam", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        Optional<User> userOptional = users.stream().filter(predicate).findFirst();
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else throw new UserNotFoundException(String.format("User with id %d not found", id));
    }

    public void deleteById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        boolean removed = users.removeIf(predicate);

        if (!removed) {
            throw new UserNotFoundException(String.format("User with id %d not found", id));
        }

    }


    public User saveUser(User user){
        count ++;
        user.setId(count);
        users.add(user);

        return user;
    }
}
