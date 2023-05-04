package com.example.urlshortener.controller;

import com.example.urlshortener.entity.ShortenURL;
import com.example.urlshortener.service.URLShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "*")
public class URLShortenerController {

    @Autowired
    URLShortenerService urlShortenerService;


    @PostMapping("/shorten")
    public ResponseEntity<Object> shortenURL(@RequestBody ShortenURL shortenURL) throws MalformedURLException {
        shortenURL = urlShortenerService.shortenURL(shortenURL);
        return new ResponseEntity<>(shortenURL, HttpStatus.OK);
    }
    @GetMapping("/{key}")
    public void redirect(HttpServletResponse response, @PathVariable String key) throws IOException {
        urlShortenerService.redirect(response, key);
    }

    @GetMapping
    public String test() {
       return "Works";
    }
}
