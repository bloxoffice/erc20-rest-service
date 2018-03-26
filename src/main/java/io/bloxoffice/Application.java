package io.bloxoffice;

import com.google.common.base.Predicates;
import io.bloxoffice.utils.Constants;
import net.bytebuddy.description.method.ParameterList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.web3j.protocol.Web3jService;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.protocol.ipc.WindowsIpcService;
import org.web3j.quorum.Quorum;

import java.util.ArrayList;
import java.util.List;

/**
 * Our main application class.
 */
@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        //SpringApplication application = new SpringApplication(Application.class);
        //application.setBannerMode(Banner.Mode.OFF);
        //application.run(args);
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    NodeConfiguration nodeConfiguration;

    @Bean
    Quorum quorum() {
        String nodeEndpoint = nodeConfiguration.getNodeEndpoint();
        Web3jService web3jService;
        if (nodeEndpoint == null || nodeEndpoint.equals("")) {
            web3jService = new HttpService();
        } else if (nodeEndpoint.startsWith("http")) {
            web3jService = new HttpService(nodeEndpoint);

        } else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            web3jService = new WindowsIpcService(nodeEndpoint);
        } else {
            web3jService = new UnixIpcService(nodeEndpoint);
        }
        return Quorum.build(web3jService);
    }

    @Bean
    public Docket lenderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(
                        getParameters()
                )
                .apiInfo(apiInfo())
                .select()
                // see https://github.com/springfox/springfox/issues/631
                .apis(Predicates.not(
                        RequestHandlerSelectors.basePackage("org.springframework.boot")))

                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BloxOffice ICO API")
                .description("BloxOffice ICO REST API's")
                .build();
    }

    //Add header parameter
    private List<Parameter> getParameters(){
        List<Parameter> parameterList = new ArrayList<>();
        ParameterBuilder builder = new ParameterBuilder();
        Parameter parameter = builder.name(Constants.AUTH_HEADER)
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .build();
        parameterList.add(parameter);
        return parameterList;
    }
}
