package io.bloxoffice.dao;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;
import io.bloxoffice.utils.Constants;

/**
 * Created by mamu on 3/24/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(expiry = 300)
public class Session {
  @Id
  @Field
  private String sessionId;
  @Field
  private String email;
  @Field
  private long expiry;
}
