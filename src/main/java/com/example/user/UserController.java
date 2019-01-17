package com.example.user;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = POST)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Created user with name " + user.getFirstName());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/{id}", method = GET)
    @ResponseBody
    public ResponseEntity<User> findUserByID(
            @PathVariable("id") long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
