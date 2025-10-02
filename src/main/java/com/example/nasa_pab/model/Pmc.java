package com.example.nasa_pab.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pmc")
public class Pmc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 229)
    private String title;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Column(name = "abstract", nullable = false, columnDefinition = "TEXT")
    private String abstractText;

    @Column(name = "journal", nullable = false, length = 176)
    private String journal;

    @Column(name = "doi", nullable = false, length = 55)
    private String doi;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "Abstract_summary", length = 503)
    private String abstractSummary;

    @Column(name = "Results_summary", length = 479)
    private String resultsSummary;

    @Column(name = "keywords", length = 626)
    private String keywords;

    @Column(name = "results", columnDefinition = "TEXT")
    private String results;

    @Column(name = "figures", columnDefinition = "TEXT")
    private String figures;

    @Column(name = "authors", length = 193)
    private String authors;

    @Column(name = "Category", nullable = false, length = 28)
    private String category;

    @Column(name = "conclusion", columnDefinition = "TEXT")
    private String conclusion;

    @Column(name = "AI_Conclusion_summary", columnDefinition = "TEXT")
    private String aiConclusionSummary;

    @Column(name = "cover_photo", length = 255)
    private String coverPhoto;

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }

    public String getJournal() { return journal; }
    public void setJournal(String journal) { this.journal = journal; }

    public String getDoi() { return doi; }
    public void setDoi(String doi) { this.doi = doi; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getAbstractSummary() { return abstractSummary; }
    public void setAbstractSummary(String abstractSummary) { this.abstractSummary = abstractSummary; }

    public String getResultsSummary() { return resultsSummary; }
    public void setResultsSummary(String resultsSummary) { this.resultsSummary = resultsSummary; }

    public String getKeywords() { return keywords; }
    public void setKeywords(String keywords) { this.keywords = keywords; }

    public String getResults() { return results; }
    public void setResults(String results) { this.results = results; }

    public String getFigures() { return figures; }
    public void setFigures(String figures) { this.figures = figures; }

    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getConclusion() { return conclusion; }
    public void setConclusion(String conclusion) { this.conclusion = conclusion; }

    public String getAiConclusionSummary() { return aiConclusionSummary; }
    public void setAiConclusionSummary(String aiConclusionSummary) { this.aiConclusionSummary = aiConclusionSummary; }

    public String getCoverPhoto() { return coverPhoto; }
    public void setCoverPhoto(String coverPhoto) { this.coverPhoto = coverPhoto; }
}
