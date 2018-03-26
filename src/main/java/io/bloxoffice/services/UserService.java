package io.bloxoffice.services;

import io.bloxoffice.dao.User;
import io.bloxoffice.repositories.UserRepository;
import io.bloxoffice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * Created by mamu on 3/24/18.
 */
@Component
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User createUser(User user) {
    user.setId(UUID.randomUUID().toString());
    return userRepository.save(user);
  }

  /**
   * Find the existing user searching by email and update the
   * details.
   * @param email
   * @param user
   * @return
   */
  public User updateUserByEmail(String email, User user) throws InvocationTargetException,
          IllegalAccessException {
    User existingUser = userRepository.findByEmail(email);
    Utils.copyNonNullProperties(user, existingUser);
    userRepository.save(existingUser);
    return existingUser;
  }

  /**
   * Fetch the user by Id and update the user
   * @param id
   * @param user
   * @return
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  public User updateUser(String id, User user) throws InvocationTargetException,
          IllegalAccessException {
    User existingUser = userRepository.findOne(id);
    Utils.copyNonNullProperties(user, existingUser);
    userRepository.save(existingUser);
    return existingUser;
  }


}

