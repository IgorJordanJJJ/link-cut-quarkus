package org.jordan.pro.app.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.jordan.pro.app.model.UrlMapping;
import org.jordan.pro.app.repository.UrlRepository;


import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UrlService {

    @Inject
    UrlRepository repository;

    @Transactional
    public String shortenUrl(String originalUrl) {
        String code = UUID.randomUUID().toString().substring(0, 8);
        UrlMapping mapping = new UrlMapping(code, originalUrl);
        repository.persist(mapping);
        return "http://localhost:8080/api/url/" + code;
    }

    public String resolveUrl(String code) {
        Optional<UrlMapping> result = repository.find("code", code).firstResultOptional();
        return result.map(UrlMapping::getOriginalUrl)
                .orElseThrow(() -> new NotFoundException("Short URL not found"));
    }
}
