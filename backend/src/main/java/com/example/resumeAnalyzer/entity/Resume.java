package com.example.resumeAnalyzer.entity;

import jakarta.persistence.*;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Lob
    private byte[] content;

    public byte[] getContent() {
        return content;
    }

    public Double getScore() {
        return score;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    private Double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String createdAt;

    public String getExtractedText() {
        return extractedText;
    }

    public void setExtractedText(String extractedText) {
        this.extractedText = extractedText;
    }

    @Column(columnDefinition = "TEXT")
    private String extractedText;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Column(columnDefinition = "TEXT")
    private String skills;

    public String getJobMatches() {
        return jobMatches;
    }

    public void setJobMatches(String jobMatches) {
        this.jobMatches = jobMatches;
    }

    @Column(columnDefinition = "TEXT")
    private String jobMatches;
}