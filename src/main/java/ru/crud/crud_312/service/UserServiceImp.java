package ru.crud.crud_312.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crud.crud_312.model.User;
import ru.crud.crud_312.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserServiceImp {

  private final UserRepository userRepository;
  @Autowired
  public UserServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public List<User> findAll() {
    return userRepository.findAll();
  }
  public User findById(long id) {
    return userRepository.findById(id).orElse(null);
  }
  @Transactional
  public void save(User user) {
    userRepository.save(user);
  }

  @Transactional
  public void updateUser(long id, User userToUpdate) {
    userToUpdate.setId(id);
    userRepository.save(userToUpdate);
  }

  @Transactional
  public void delete(long id) {
    userRepository.deleteById(id);
  }
}