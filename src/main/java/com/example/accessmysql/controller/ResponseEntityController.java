package com.example.accessmysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.accessmysql.model.User;
import com.example.accessmysql.service.UserService;


@RestController
				//	/user is the start of all urls for this controller, ie. /users/1 would pull first user in the DB using getUserById
@RequestMapping(value = "/users", produces = "application/json", consumes = "application/json")
public class ResponseEntityController {
	
    //private final UserService userService;
    
   // @Autowired //using autowire on constructor
   // public UserController(UserService userService) {
   //     this.userService = userService;
   // }
    
	@Autowired
    private UserService userService;
    
    @PostMapping //create+save+return new user
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    
    
    @GetMapping("/{id}") //get a user by id
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    
    @GetMapping("/getAllUsers")//get list of all users
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    
    @DeleteMapping("/{id}") //delete a user by id
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}