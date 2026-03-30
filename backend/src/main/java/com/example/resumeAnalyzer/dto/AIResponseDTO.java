package com.example.resumeAnalyzer.dto;

import java.util.List;
import java.util.Map;


public class AIResponseDTO {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private String text;
    private List<String> skills;
    private Integer score;

    public Map<String, Double> getJob_matches() {
        return job_matches;
    }

    public void setJob_matches(Map<String, Double> job_matches) {
        this.job_matches = job_matches;
    }

    private Map<String, Double> job_matches;
}