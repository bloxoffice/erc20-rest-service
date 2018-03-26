package io.bloxoffice.config;

import io.bloxoffice.NodeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mamu on 3/26/18.
 */
@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration{

  @Autowired
  private NodeConfiguration nodeConfiguration;

  /**
   *
   * The list of hostnames (or IP addresses) to bootstrap from.
   *
   * @return the list of bootstrap hosts.
   */
  @Override
  protected List<String> getBootstrapHosts() {
    List<String> hosts = new ArrayList<>();
    hosts.add(nodeConfiguration.getCouchbaseHostName());
    return hosts;
  }

  /**
   * The name of the bucket to connect to.
   *
   * @return the name of the bucket.
   */
  @Override
  protected String getBucketName() {
    return nodeConfiguration.getCouchbaseBucketName();
  }

  /**
   * The password of the bucket (can be an empty string).
   *
   * @return the password of the bucket.
   */
  @Override
  protected String getBucketPassword() {
    return nodeConfiguration.getCouchbasePassword();
  }

}
