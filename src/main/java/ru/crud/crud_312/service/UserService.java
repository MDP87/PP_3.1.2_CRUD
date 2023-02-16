package ru.crud.crud_312.service;

import java.util.List;
import ru.crud.crud_312.model.User;

public interface UserService {

  List<User> findAll();

  User findById(long id);

  void save(User user);

  void updateUser(long id, User user);

  void delete(long id);

}
