package io.bloxoffice.controllers;

import io.bloxoffice.dao.User;
import io.bloxoffice.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by mamu on 3/24/18.
 */
@Api("User Management")
@RestController
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping(method = RequestMethod.PUT, path = "/user/{id}")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User updateUser(@PathVariable String id, @RequestBody User user) throws InvocationTargetException,
          IllegalAccessException {
    return userService.updateUser(id, user);
  }
}
