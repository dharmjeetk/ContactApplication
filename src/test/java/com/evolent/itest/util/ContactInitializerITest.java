package com.evolent.itest.util;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evolent.config.RESTInitializer;

public class ContactInitializerITest implements ApplicationContextInitializer<ConfigurableApplicationContext>{

	public void initialize(ConfigurableApplicationContext applicationContext) {
		applicationContext.setParent(new AnnotationConfigApplicationContext(RESTInitializer.class));
	}

}
