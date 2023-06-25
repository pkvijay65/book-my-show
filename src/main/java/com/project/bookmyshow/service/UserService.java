package com.project.bookmyshow.service;

import com.project.bookmyshow.models.User;
import com.project.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User signUp(String name, String email, String password) {
    User user = new User();
    user.setName(name);
    user.setEmail(email);

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    user.setPassword(passwordEncoder.encode(password));
    return userRepository.save(user);
  }
}
