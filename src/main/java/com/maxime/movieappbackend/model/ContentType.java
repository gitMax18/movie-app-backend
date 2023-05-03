package com.maxime.movieappbackend.model;

public enum ContentType {
    ANIME("ANIME"),
    MOVIE("MOVIE"),
    SERIE("SERIE");

    private final String contentType;

    private ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return this.contentType;
    }
}
