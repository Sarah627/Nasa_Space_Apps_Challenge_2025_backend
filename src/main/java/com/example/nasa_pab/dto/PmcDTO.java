package com.example.nasa_pab.dto;

public class PmcDTO {
    private String title;
    private String authors;
    private String keywords;
    private String abstractText;
    private String coverPhoto;
    private String category;

    public PmcDTO() {}

    public PmcDTO(String coverPhoto, String title, String authors, String keywords, String abstractText, String category) {
        this.coverPhoto = coverPhoto;
        this.title = title;
        this.authors = authors;
        this.keywords = keywords;
        this.abstractText = abstractText;
        this.category = category;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }

    public String getKeywords() { return keywords; }
    public void setKeywords(String keywords) { this.keywords = keywords; }

    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }

    public String getCoverPhoto() { return coverPhoto; }
    public void setCoverPhoto(String coverPhoto) { this.coverPhoto = coverPhoto; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
