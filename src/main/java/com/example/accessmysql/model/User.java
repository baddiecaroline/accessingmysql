package com.example.accessmysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Automatically makes entity a table in the DB

public class User {
 
//fields
  @Id    //denotes primary key for table
  @GeneratedValue(strategy=GenerationType.AUTO)  //generates auto-intcremented id for each new user object
  private Integer id;

  private String name;

  private String email;

  //getters & setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}