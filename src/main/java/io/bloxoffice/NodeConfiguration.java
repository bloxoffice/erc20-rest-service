package io.bloxoffice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Node configuration bean.
 */
@Data
@ConfigurationProperties
@Component
public class NodeConfiguration {

    private String nodeEndpoint;
    private String fromAddress;
    private String bbtcContractAddress;
    private String couchbaseHostName;
    private String couchbaseBucketName;
    private String couchbasePassword;
}
