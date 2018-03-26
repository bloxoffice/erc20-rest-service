package io.bloxoffice.dao;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.List;

/**
 * Created by mamu on 3/24/18.
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
  @Id
  @Field
  private String id;
  @Field
  private String firstName;
  @Field
  private String lastName;
  @Field
  private String email;
  @Field
  private String phone;
  @Field
  private String address;
  @Field
  private String password;
  @Field
  private String salt;
  @Field
  private String zipcode;
  @Field
  private String country;
  @Field
  private boolean enable2factor;
  @Field
  private boolean emailVerified;
  @Field
  private String imageUrl;
  @Field
  private String proofOfIdentity;
  @Field
  private String proofOfAddress;
  @Field
  private List<Transaction> transactions;
}
