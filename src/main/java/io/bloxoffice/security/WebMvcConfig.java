package io.bloxoffice.security;

import io.bloxoffice.services.AccessControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by mamu on 3/26/18.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
  @Autowired
  private RequestInterceptor requestInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(requestInterceptor);
  }
}
