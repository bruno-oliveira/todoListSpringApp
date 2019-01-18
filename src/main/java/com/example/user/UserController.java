package com.example.user;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {


    @RequestMapping(value = "/user", method = POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Created user with name " + user.getFirstName());
        //Save user to db....
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/login", method = POST)
    public Long login(@RequestBody User user) {
        System.out.println("Login user with first name " + user.getFirstName());
      return user.getId();
    }

    @RequestMapping(value = "/user/logout", method = POST)
    public Long logout(@RequestBody User user) {
        System.out.println("Logging out user with first name " + user.getFirstName());
        return user.getId();
    }

    @RequestMapping(value = "/user/{id}", method = GET)
    public ResponseEntity<User> findUserByID(
            @PathVariable("id") long id) {
        Optional<User> optionalUser = Optional.empty();
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/user/{id}/profile", method = GET)
    public UserProfile getUserProfile(
            @PathVariable("id") long id) {
        UserProfile userProfile = new UserProfile("brunoOliveira","olivbruno8@gmail.com","Bruno","Oliveira", Collections.emptyList());
        return userProfile;
    }


}
