package com.example.urlshortener.service;

import com.example.urlshortener.dto.CreateShortUrlRequest;
import com.example.urlshortener.dto.ShortUrlDto;
import com.example.urlshortener.dto.converter.ShortUrlDtoConverter;
import com.example.urlshortener.exception.CodeAlreadyExists;
import com.example.urlshortener.exception.ShortUrlNotFoundException;
import com.example.urlshortener.model.ShortUrl;
import com.example.urlshortener.repository.ShortUrlRepository;
import com.example.urlshortener.utils.RandomStringGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository repository;
    private final RandomStringGenerator randomStringGenerator;
    private final ShortUrlDtoConverter dtoConverter;

    protected ShortUrl findShortUrlByCode(String code){
        return repository.findByCode(code).orElseThrow(
                ()-> new ShortUrlNotFoundException("url not found!")
        );
    }

    public ShortUrlDto getShortUrlByCode(String code){
        return dtoConverter.convertToDto(findShortUrlByCode(code));
    }

    public List<ShortUrlDto> getAllShortUrls(){
        return repository.findAll()
                .stream()
                .map(dtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public ShortUrlDto createShortUrl(CreateShortUrlRequest request){
        if (request.getCode() == null || request.getCode().isEmpty()){
            request.setCode(generateCode());
        }else if (repository.findByCode(request.getCode()).isPresent()){
            throw new CodeAlreadyExists("code already exists");
        }

        ShortUrl shortUrl = ShortUrl.builder()
                .code(request.getCode())
                .url(request.getUrl())
                .build();

        return dtoConverter.convertToDto(repository.save(shortUrl));
    }

    private String generateCode(){
        String code;
        do {
            code = randomStringGenerator.generateRandomString();
        }while (repository.findByCode(code).isPresent());

        return code;
    }
}
