package io.bloxoffice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mamu on 3/26/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInModel {
  private String email;
  private String password;
}
