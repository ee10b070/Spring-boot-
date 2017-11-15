package com.memorytest.test;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface BookClient {
    @RequestLine("GET /{isbn}")
    BookModel findByIsbn(@Param("isbn") String isbn);

    @RequestLine("GET")
    List<BookModel> findAll();
    
    @RequestLine("GET")
    String Testing();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(BookModel book);
}