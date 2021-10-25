package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repository.UserRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRep userRep;

  public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
    if (userRep.findByUsername(user.getUsername()) != null) {
      throw new UserAlreadyExistException("User is already exist!");
    }
    return userRep.save(user);
  }

  public User getOne(Long id) throws UserNotFoundException {
    UserEntity user = userRep.findById(id).get();
    if (user == null) {
      throw new UserNotFoundException("User Not Found");
    }
    return User.toModel(user);
  }

  public void deleteUser(Long id) throws UserNotFoundException {
    if (!userRep.existsById(id)) {
      throw new UserNotFoundException("User Not Found");
    }
    userRep.deleteById(id);
  }

  public UserEntity updateUser(Long id, UserEntity user) throws UserNotFoundException {
    UserEntity entity = userRep.findById(id).get();
    if (entity == null) {
      throw new UserNotFoundException("User Not Found");
    }
    if (user.getUsername() != null)
      entity.setUsername(user.getUsername());
    if (user.getPassword() != null)
      entity.setUsername(user.getPassword());
    return userRep.save(entity);
  }
}
