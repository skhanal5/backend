package com.skhanal5.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AppController {

    @GetMapping
    public String getDummy() {
        return "Currently at a dummy endpoint :)";
    }

    @GetMapping
    public String getBookByName(String name) throws Exception {
        throw new Exception("getBookByName is not implemented yet");
    }

    @GetMapping
    public String getBooksByGenre(String genre) throws Exception {
        throw new Exception("getBookByName is not implemented yet");
    }

    @GetMapping
    public String getBookByISBN(String genre) throws Exception {
        throw new Exception("getBookByName is not implemented yet");
    }
}
