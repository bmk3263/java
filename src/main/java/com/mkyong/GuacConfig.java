package com.mkyong;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuacConfig {
	 @Bean
	    public TutorialGuacamoleTunnelServlet tutorialGuacamoleTunnelServlet(){
	        return new TutorialGuacamoleTunnelServlet();
	    }

	    @Bean
	    public ServletRegistrationBean servletRegistrationBean(){
	        return new ServletRegistrationBean(tutorialGuacamoleTunnelServlet(), "/tunnel");
	    }
}
