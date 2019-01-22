package com.example.user;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        boolean wasSucessfullyCreated = userService.create(user);
        if (wasSucessfullyCreated) {
            System.out.println("Created user " + user.getId());
        } else {
            System.out.println("User with the id " + user.getId() + " already exists");
        }
        return wasSucessfullyCreated ? ResponseEntity.ok(user) : new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
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
        //TODO handle conversions ....
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
        userService.delete(id);
        System.out.println("Delete user with ID " + id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
