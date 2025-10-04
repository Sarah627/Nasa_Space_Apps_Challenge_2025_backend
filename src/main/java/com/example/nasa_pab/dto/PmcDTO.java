package com.example.nasa_pab.dto;

public class PmcDTO {
    private Long id;
    private String title;
    private String authors;
    private String keywords;
    private String abstractText;
    private String coverPhoto;
    private String category;
    private String paperUrl;

    public PmcDTO() {}

    public PmcDTO( Long id,String coverPhoto, String title, String authors, String keywords, String abstractText, String category, String paperUrl) {
        this.id=id;
        this.coverPhoto = coverPhoto;
        this.title = title;
        this.authors = authors;
        this.keywords = keywords;
        this.abstractText = abstractText;
        this.category = category;
        this.paperUrl=paperUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getPaperUrl() { return paperUrl; }
    public void setPaperUrl(String paperUrl) { this.paperUrl = paperUrl; }
}
