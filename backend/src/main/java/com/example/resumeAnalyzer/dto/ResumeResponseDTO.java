package com.example.resumeAnalyzer.dto;

import java.util.Map;


public class ResumeResponseDTO {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    private Double score;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    private String skills;

    public Map<String, Double> getJob_matches() {
        return job_matches;
    }

    public void setJob_matches(Map<String, Double> job_matches) {
        this.job_matches = job_matches;
    }

    private Map<String, Double> job_matches;
}