package com.example.urlshortener.service;

import com.example.urlshortener.TestSupport;
import com.example.urlshortener.dto.CreateShortUrlRequest;
import com.example.urlshortener.dto.ShortUrlDto;
import com.example.urlshortener.dto.converter.ShortUrlDtoConverter;
import com.example.urlshortener.exception.CodeAlreadyExists;
import com.example.urlshortener.exception.ShortUrlNotFoundException;
import com.example.urlshortener.model.ShortUrl;
import com.example.urlshortener.repository.ShortUrlRepository;
import com.example.urlshortener.utils.RandomStringGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ShortUrlServiceTest extends TestSupport {
    ShortUrlService service;
    ShortUrlRepository repository;
    ShortUrlDtoConverter dtoConverter;
    RandomStringGenerator randomStringGenerator;


    @BeforeEach
    public void setup() {
        repository = mock(ShortUrlRepository.class);
        dtoConverter = mock(ShortUrlDtoConverter.class);
        randomStringGenerator = mock(RandomStringGenerator.class);

        service = new ShortUrlService(repository, randomStringGenerator, dtoConverter);
    }

    @Test
    public void testGetShortUrlByCode_shouldReturnShortUrlDto_whenCodeAndUrlExists(){
        ShortUrl shortUrl = generateShortUrl();
        ShortUrlDto expected = generateShortUrlDto();

        Mockito.when(repository.findByCode(SHORTURL_CODE)).thenReturn(Optional.of(shortUrl));
        Mockito.when(dtoConverter.convertToDto(shortUrl)).thenReturn(expected);

        ShortUrlDto result = service.getShortUrlByCode(SHORTURL_CODE);

        assertEquals(expected, result);

        Mockito.verify(repository).findByCode(SHORTURL_CODE);
        Mockito.verify(dtoConverter).convertToDto(shortUrl);
    }

    @Test
    public void testGetShortUrlByCode_shouldThrowShortUrlNotFoundException_whenCodeExistsButUrlDoesNotExists(){
        Mockito.when(repository.findByCode(SHORTURL_CODE)).thenReturn(Optional.empty());

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> service.getShortUrlByCode(SHORTURL_CODE))
                        .isInstanceOf(ShortUrlNotFoundException.class)
                        .hasMessageContaining("url not found!");

        Mockito.verify(repository).findByCode(SHORTURL_CODE);
        Mockito.verifyNoInteractions(dtoConverter);
    }

    @Test
    public void testCreateShortUrl_shouldReturnShortUrlDto_whenUrlAndCodeExists(){
        CreateShortUrlRequest request = CreateShortUrlRequest.builder()
                                                .url(SHORTURL_URL)
                                                .code(SHORTURL_CODE)
                                                .build();
        ShortUrl shortUrlWithoutId = ShortUrl.builder()
                .code(request.getCode())
                .url(request.getUrl())
                .build();

        ShortUrl shortUrl = generateShortUrl();
        ShortUrlDto expected = generateShortUrlDto();

        Mockito.when(repository.findByCode(SHORTURL_CODE)).thenReturn(Optional.empty());
        Mockito.when(repository.save(shortUrlWithoutId)).thenReturn(shortUrl);
        Mockito.when(dtoConverter.convertToDto(shortUrl)).thenReturn(expected);

        ShortUrlDto result = service.createShortUrl(request);

        assertEquals(expected, result);

        Mockito.verify(repository).findByCode(SHORTURL_CODE);
        Mockito.verify(repository).save(shortUrlWithoutId);
        Mockito.verify(dtoConverter).convertToDto(shortUrl);
    }

    @Test
    public void testCreateShortUrl_shouldReturnShortUrlDto_whenUrlExistsAndCodeDoesNotExists(){
        CreateShortUrlRequest request = CreateShortUrlRequest.builder()
                .url(SHORTURL_URL)
                .build();
        ShortUrl shortUrlWithoutId = ShortUrl.builder()
                .code(SHORTURL_CODE)
                .url(request.getUrl())
                .build();

        ShortUrl shortUrl = generateShortUrl();
        ShortUrlDto expected = generateShortUrlDto();

        Mockito.when(randomStringGenerator.generateRandomString()).thenReturn(SHORTURL_CODE);
        Mockito.when(repository.findByCode(SHORTURL_CODE)).thenReturn(Optional.empty());
        Mockito.when(repository.save(shortUrlWithoutId)).thenReturn(shortUrl);
        Mockito.when(dtoConverter.convertToDto(shortUrl)).thenReturn(expected);

        ShortUrlDto result = service.createShortUrl(request);

        assertEquals(expected, result);

        Mockito.verify(randomStringGenerator).generateRandomString();
        Mockito.verify(repository).findByCode(SHORTURL_CODE);
        Mockito.verify(repository).save(shortUrlWithoutId);
        Mockito.verify(dtoConverter).convertToDto(shortUrl);
    }

    @Test
    public void testCreateShortUrl_shouldThrowCodeAlreadyExists_whenUrlAndCodeExistsButCodeAlreadyUsed(){
        CreateShortUrlRequest request = CreateShortUrlRequest.builder()
                .code(SHORTURL_CODE)
                .url(SHORTURL_URL)
                .build();

        ShortUrl shortUrl = generateShortUrl();

        Mockito.when(repository.findByCode(SHORTURL_CODE)).thenReturn(Optional.of(shortUrl));

        assertThrows(CodeAlreadyExists.class, () -> service.createShortUrl(request));

        Mockito.verify(repository).findByCode(SHORTURL_CODE);
        Mockito.verifyNoInteractions(randomStringGenerator);
        Mockito.verifyNoInteractions(dtoConverter);
    }

}
