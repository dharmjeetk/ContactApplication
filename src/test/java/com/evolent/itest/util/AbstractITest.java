package com.evolent.itest.util;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(initializers = ContactInitializerITest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractITest {

}
