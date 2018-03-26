package io.bloxoffice.repositories;

import io.bloxoffice.dao.Session;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

/**
 * Created by mamu on 3/26/18.
 */
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "session")
public interface SessionRepository extends CouchbasePagingAndSortingRepository<Session, String>{
  public Session findByEmail(String email);
}
