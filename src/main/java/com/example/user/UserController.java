package com.example.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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
    public ResponseEntity logout() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}/profile", method = GET)
    public UserProfile getUserProfile(
            @PathVariable("id") long id) {
        UserProfile userProfile = new UserProfile("brunoOliveira","olivbruno8@gmail.com","Bruno","Oliveira", Collections.emptyList());
        return userProfile;
    }

    @RequestMapping(value = "/user/{id}/profile", method = PUT)
    public UserProfile editUserProfile(
            @PathVariable("id") long id, @RequestBody UserProfile userProfile) {
        return userProfile;
    }

    @RequestMapping(value = "/user/{id}", method = DELETE)
    public ResponseEntity deleteUser(
            @PathVariable("id") long id) {
        System.out.println("Delete user with ID " + id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
