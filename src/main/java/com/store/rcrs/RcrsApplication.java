package com.store.rcrs;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServlet;


@SpringBootApplication
public class RcrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RcrsApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<HttpServlet> h2ServletRegistrationBean() {
		var registrationBean = new ServletRegistrationBean<HttpServlet>(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
