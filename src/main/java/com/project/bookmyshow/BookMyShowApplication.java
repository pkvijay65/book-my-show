package com.project.bookmyshow;

import com.project.bookmyshow.controller.UserController;
import com.project.bookmyshow.dto.SignUpUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
  private UserController userController;

  @Autowired
  public BookMyShowApplication(UserController userController) {
    this.userController = userController;
  }
  public static void main(String[] args) {
    SpringApplication.run(BookMyShowApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    SignUpUserRequestDto request = new SignUpUserRequestDto();
    request.setEmail("prateek@gmail.com");
    request.setPassword("password");
    userController.signUpUser(request);
  }

}
