package io.bloxoffice.dao;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * Created by mamu on 3/24/18.
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
  @Id
  @Field
  private String id;
  @Field
  private String etherAddress;
  @Field
  private long timestamp;
  @Field
  private String status;
}
