
package com.frauddetection.backend;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean<ProjectStatusServlet> projectStatusServlet() {
        return new ServletRegistrationBean<>(
                new ProjectStatusServlet(),
                "/servlet/status"
        );
    }
}
