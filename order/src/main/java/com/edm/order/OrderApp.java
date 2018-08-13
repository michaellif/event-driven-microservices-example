package com.edm.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackageClasses = { com.edm.RootMarker.class })
public class OrderApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new OrderApp().configure(new SpringApplicationBuilder(OrderApp.class)).run(args);
	}

}
