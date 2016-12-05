package com.rgc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.DB;
import com.rgc.service.RgcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/rgc/application-context.xml" })
@TestPropertySource(locations = { "/application.properties" })
public class RgcServiceTest {

	@Autowired
	private RgcService service;

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void testMongo() {
		System.out.println(ctx.getEnvironment().getProperty("spring.data.mongodb.uri"));
		assertThat(service.serviceUp()).isEqualTo("Up");
		DB db = service.getMongoRgcDb();
		assertThat(db).isNotNull();
		System.out.println(db.getName());
		System.out.println(db.getStats());
	}
}
