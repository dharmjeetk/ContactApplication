package com.evolent.backend.dao;

import java.util.Random;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This is unique id generator for contact id column in DB
 * 
 * @author dharmjeet.kumar
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {


	public int getNextId() {
		
		Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	
	}
}