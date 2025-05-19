package org.jordan.pro.app.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UrlMapping extends PanacheEntityBase {

    @Id
    private String code;

    private String originalUrl;

    public UrlMapping() {}

    public UrlMapping(String code, String originalUrl) {
        this.code = code;
        this.originalUrl = originalUrl;
    }

    public String getCode() {
        return code;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
