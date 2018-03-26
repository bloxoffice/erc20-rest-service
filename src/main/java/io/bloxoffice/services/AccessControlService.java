package io.bloxoffice.services;

import io.bloxoffice.dao.Session;
import io.bloxoffice.dao.User;
import io.bloxoffice.exceptions.DatabaseException;
import io.bloxoffice.exceptions.EmailAlreadyExistsException;
import io.bloxoffice.exceptions.InvalidUserException;
import io.bloxoffice.exceptions.UserNotFoundException;
import io.bloxoffice.models.SignInModel;
import io.bloxoffice.models.UserModel;
import io.bloxoffice.repositories.SessionRepository;
import io.bloxoffice.repositories.UserRepository;
import io.bloxoffice.utils.Constants;
import io.bloxoffice.utils.Utils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * Created by mamu on 3/26/18.
 */
@Component
public class AccessControlService {

  private static final Logger log = LoggerFactory.getLogger(AccessControlService.class);

  @Autowired
  private SessionRepository sessionRepository;

  @Autowired
  private UserRepository userRepository;


  public boolean signup(UserModel userModel){
    boolean userCreated = true;
    User user = new User();

    //Check if the email exists
    if(userRepository.findByEmail(userModel.getEmail()) != null){
      throw new EmailAlreadyExistsException("Email "+userModel.getEmail()+" already exists");
    }

    try {
      BeanUtils.copyProperties(userModel, user);
      //Utils.copyNonNullProperties(userModel, user);
      //Create a user Id
      user.setId(UUID.randomUUID().toString());
      user.setEmailVerified(true); //Change send email
      user.setEnable2factor(false);
      hashPassword(user, userModel.getPassword());
      //TODO: Send email verification

      userRepository.save(user);
    } catch (DatabaseException e) {
      userCreated = false;
      log.error("Error creating user "+ e.getMessage(), e);
    }
    return userCreated;
  }

  public boolean verifyEmail(String email, String verificationCode){
    return false;
  }


  private void hashPassword(User user, String password) {
    // Hash a password for the first time
    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
    user.setPassword(hashed);
  }

  public Session signin(SignInModel signInModel){
    Session session = null;
    //Fetch user
    User user = userRepository.findByEmail(signInModel.getEmail());
    if(user == null){
      log.error("cannot find user "+signInModel.getEmail());
      throw new UserNotFoundException("Cannot find User "+signInModel.getEmail());
    }

    //Check if session exists if so remove
    session = sessionRepository.findByEmail(signInModel.getEmail());
    if(session != null){
      sessionRepository.delete(session);
      session = null;
    }
    //Check for authentication and create session
    if(BCrypt.checkpw(signInModel.getPassword(), user.getPassword())){
      //Create a session
      session = new Session();
      session.setSessionId(UUID.randomUUID().toString());
      session.setEmail(signInModel.getEmail());
      session.setExpiry(Constants.EXPIRY_SEC);
      sessionRepository.save(session);
    } else {
      log.error("Authentication failed for user "+ signInModel.getEmail());
      throw new InvalidUserException("Authentication failed for user "+ signInModel.getEmail());
    }
    return session;
  }

  /**
   * Validate the session header, if the sessionkey is expired or invalid it
   * will return false else it will return true
   * @param sessionKey
   * @return
   */
  public boolean checkSession(String sessionKey){
    boolean validSession = true;
    Session session = sessionRepository.findOne(sessionKey);
    if(session == null){
      validSession = false;
    } else if(session.getSessionId().equalsIgnoreCase(sessionKey)){
      validSession = false;
    } else {
      validSession = true;
    }
    return validSession;
  }

}
