package io.bloxoffice.controllers;

import io.bloxoffice.dao.Session;
import io.bloxoffice.models.SignInModel;
import io.bloxoffice.models.UserModel;
import io.bloxoffice.services.AccessControlService;
import io.bloxoffice.utils.Constants;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mamu on 3/26/18.
 */

@RestController
public class AccessController {

  @Autowired
  private AccessControlService accessControlService;

  /**
   * Signup new user.
   * @param userModel
   * @return
   */
  @RequestMapping(path = "signup", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public boolean signup(@RequestBody UserModel userModel){
    return accessControlService.signup(userModel);
  }

  @RequestMapping(path = "signin", method = RequestMethod.POST)
    public Session signin(@RequestBody SignInModel signInModel){
    return accessControlService.signin(signInModel);
  }

  @RequestMapping(path = "signout", method = RequestMethod.GET)
  public void signin(HttpServletRequest request){
    String sessionId = request.getHeader(Constants.AUTH_HEADER);
    accessControlService.signout(sessionId);
  }
}
