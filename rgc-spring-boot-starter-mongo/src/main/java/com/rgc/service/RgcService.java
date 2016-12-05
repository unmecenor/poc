package com.rgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.DB;

@Component
public class RgcService {

	@Autowired
	private MongoDbFactory mongoDbFactory;

	public DB getMongoRgcDb() {
		return mongoDbFactory.getDb();
	}

	public String serviceUp() {
		return "Up";
	}

}
