package com.example.accessmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.accessmysql.dao.UserRepository;
import com.example.accessmysql.model.User;


@RestController // This means that this class is a RestController which returns data instead of a view

@RequestMapping(path="/demo") // This means MainController URL's start with /demo (after Application path)

public class MainController {

	 @Autowired // This will get the bean called userRepository when app runs
	 			// Bean is auto-generated by Spring, we will use it to handle the data
private UserRepository userRepository; //object of the interface UserRepository in MainController class

@PostMapping("/add") // Map ONLY POST Requests accessed at URL/add
public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
// @ResponseBody means the returned String is the response, not a view name
// @RequestParam means it is a parameter from the GET or POST request

	User n = new User();
	n.setName(name);
	n.setEmail(email);
	userRepository.save(n); //.save method saves new user in DB
	return "Saved";
}


@GetMapping(path="/all") //Only GET requests can access this method
					
//Iterable does a for each loop to get all users
public @ResponseBody Iterable<User> getAllUsers() {
  
	// .findAll method returns a JSON or XML with all users in the table
  Iterable<User> allUsersInDB = userRepository.findAll();
  return allUsersInDB;
}

}
