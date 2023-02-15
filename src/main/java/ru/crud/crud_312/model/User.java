package ru.crud.crud_312.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name = "users")
public class User {
  @Id
  @Column(name = "user_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name", nullable = false)
  @NotEmpty(message = "Enter correct name")
  @Size(min = 2, max = 10, message = "Name should be from 2 to 10 symbols")
  private String firstName;

  @NotEmpty(message = "Enter correct last name")
  @Size(min = 2, max = 20, message = "Last Name should be from 2 to 20 symbols")
  @Column(name = "lastName", nullable = false)
  private String lastName;

  @NotEmpty(message = "Enter correct email")
  @Email(message = "Enter correct email")
  @Column(name = "email", nullable = false)
  private String email;
  public User() {}
  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  @Override
  public String toString() {
    return String.format("Id = %s \n First name = %s \n" +
        " Last name = %s \n Email = %s \n", getId(), getFirstName(), getLastName(), getEmail());
  }
}



