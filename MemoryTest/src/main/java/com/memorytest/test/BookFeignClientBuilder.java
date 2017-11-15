package com.memorytest.test;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class BookFeignClientBuilder {
	/* private BookClient bookClient = createClient(BookClient.class, "http://localhost:8080/api/books");

	    private static <T> T createClient(Class<T> type, String uri) {
	        return Feign.builder()
	            .client(new OkHttpClient())
	            .encoder(new GsonEncoder())
	            .decoder(new GsonDecoder())
	            .logger(new Slf4jLogger(type))
	            .logLevel(Logger.Level.FULL)
	            .target(type, uri);
	    }*/
    	BookClient bookClient = Feign.builder()
    			.client(new OkHttpClient())
	            .encoder(new GsonEncoder())
	            .decoder(new GsonDecoder())
	            .logger(new Slf4jLogger(BookClient.class))
	            .logLevel(Logger.Level.FULL)
			  .target(BookClient.class, "http://localhost:8081/api/books");
}




