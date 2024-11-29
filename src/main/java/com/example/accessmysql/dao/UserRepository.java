package com.example.accessmysql.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.accessmysql.model.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//Bean created == private UserRepository userRepository;

										//CRUD refers Create, Read, Update, Delete
										//CrudRepository is an interface provided by Spring that gives access to CRUD operations + methods
										// CrudRepo takes in two values <entity, PRIKEY datatype>
public interface UserRepository extends CrudRepository<User, Integer> {

}
