package io.bloxoffice.repositories;

import io.bloxoffice.dao.User;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mamu on 3/24/18.
 */
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "user")
public interface UserRepository extends CouchbasePagingAndSortingRepository<User, String> {
  @Query("#{#n1ql.selectEntity} where #{#n1ql.filter} and email = $1")
  User findByEmail(String email);
}
