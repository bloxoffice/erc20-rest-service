package io.bloxoffice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mamu on 3/26/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String address;
  private String zipcode;
  private String country;
  private String password;

}
