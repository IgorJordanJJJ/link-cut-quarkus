package org.jordan.pro.app.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jordan.pro.app.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

@Path("/url")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UrlController {

    private static final Logger log = LoggerFactory.getLogger(UrlController.class);

    @Inject
    UrlService urlService;

    public static class ShortenRequest {
        public String originalUrl;
    }

    public static class ShortenResponse {
        public String shortUrl;

        public ShortenResponse(String shortUrl) {
            this.shortUrl = shortUrl;
        }
    }

    @POST
    @Path("/shorten")
    public Response shorten(ShortenRequest request) {
        String shortUrl = urlService.shortenUrl(request.originalUrl);
        return Response.ok(new ShortenResponse(shortUrl)).build();
    }

    @GET
    @Path("/{code}")
    public Response redirect(@PathParam("code") String code) {
        String originalUrl = urlService.resolveUrl(code);
        log.info("code: " + code + " originalUrl: " + originalUrl);

        //return Response.ok().entity(originalUrl).build();
        return Response.temporaryRedirect(URI.create(originalUrl)).build();
    }
}
