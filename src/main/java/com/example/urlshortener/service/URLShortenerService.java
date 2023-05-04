package com.example.urlshortener.service;

import com.example.urlshortener.entity.ShortenURL;
import com.example.urlshortener.util.Util;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@Service
public class URLShortenerService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${deployment.url}")
    private String url;

    public ShortenURL shortenURL(ShortenURL shortenURL) throws MalformedURLException {
        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        if(!urlValidator.isValid(shortenURL.getOriginalURL())) {
            throw new MalformedURLException("Invalid URL");
        }
        String key = Util.getRandomString();
        shortenURL.setShortURL(url + "/" + key);
        redisTemplate.opsForValue().set(key, shortenURL.getOriginalURL());
        return shortenURL;
    }

    public void redirect(HttpServletResponse response, String key) throws IOException {
        response.sendRedirect(redisTemplate.opsForValue().get(key));
    }


}
