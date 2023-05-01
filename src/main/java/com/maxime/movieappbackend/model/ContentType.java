package com.maxime.movieappbackend.model;

public enum ContentType {
    ANIME("ANIME"),
    MOVIE("MOVIE");

    private final String contentType;

    private ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return this.contentType;
    }
}
