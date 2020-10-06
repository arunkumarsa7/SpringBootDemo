package com.ensat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class WebAppApplicationTests {

	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-junit-resttemplate/
	@Test
	public void contextLoads() {
		Assert.assertEquals(200, 300);
	}

}
