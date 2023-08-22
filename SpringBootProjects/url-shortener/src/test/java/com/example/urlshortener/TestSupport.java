package com.example.urlshortener;

import com.example.urlshortener.dto.ShortUrlDto;
import com.example.urlshortener.model.ShortUrl;

public class TestSupport {
    public static final String SHORTURL_API_ENDPOINT = "/api/v1/";
    public static final Long SHORTURL_ID = 1234l;
    public static final String SHORTURL_URL = "shortUrl-url";
    public static final String SHORTURL_CODE = "shortUrl-code";

    public ShortUrl generateShortUrl(){
        return ShortUrl.builder()
                .id(SHORTURL_ID)
                .url(SHORTURL_URL)
                .code(SHORTURL_CODE)
                .build();
    }

    public ShortUrlDto generateShortUrlDto(){
        return ShortUrlDto.builder()
                .id(SHORTURL_ID)
                .url(SHORTURL_URL)
                .code(SHORTURL_CODE)
                .build();
    }

}
