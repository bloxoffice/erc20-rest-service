package io.bloxoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by mamu on 3/12/18.
 */
@RestController
public class EmailController {

  @Autowired
  private EmailService emailService;

  @RequestMapping(path = "/sendEmail/{email}", method = RequestMethod.GET)
  public void sendEmail(@PathVariable String email) throws IOException {
    emailService.sendJoinListEmail(email);
  }
}
