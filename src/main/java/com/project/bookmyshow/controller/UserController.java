package com.project.bookmyshow.controller;

import com.project.bookmyshow.dto.SignUpUserRequestDto;
import com.project.bookmyshow.dto.SignUpUserResponseDto;
import com.project.bookmyshow.models.User;
import com.project.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
  private final UserService userService;
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  public SignUpUserResponseDto signUpUser(SignUpUserRequestDto signUpUserRequestDto) {

    User user = userService.signUp(signUpUserRequestDto.getName(), signUpUserRequestDto.getEmail(), signUpUserRequestDto.getPassword());
    SignUpUserResponseDto signUpUserResponseDto = new SignUpUserResponseDto();
    signUpUserResponseDto.setUserId(user.getId());
    return signUpUserResponseDto;
  }
}
