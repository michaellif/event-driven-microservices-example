package com.edm.customer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackageClasses = { com.edm.RootMarker.class })
public class CustomerApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new CustomerApp().configure(new SpringApplicationBuilder(CustomerApp.class)).run(args);
	}

}
