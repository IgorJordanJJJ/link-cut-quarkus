package org.jordan.pro.app.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jordan.pro.app.model.UrlMapping;

@ApplicationScoped
public class UrlRepository implements PanacheRepository<UrlMapping> {
}
