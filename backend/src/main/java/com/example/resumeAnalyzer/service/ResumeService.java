package com.example.resumeAnalyzer.service;

import com.example.resumeAnalyzer.dto.AIResponseDTO;
import com.example.resumeAnalyzer.dto.ResumeResponseDTO;
import com.example.resumeAnalyzer.entity.Resume;
import com.example.resumeAnalyzer.repository.ResumeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository repository;
    private final AIService aiService;
    public ResumeService(ResumeRepository repository, AIService aiService) {
        this.repository = repository;
        this.aiService = aiService;
    }

    public ResumeResponseDTO saveResume(MultipartFile file) throws IOException, IOException {
        byte[] bytes = file.getBytes();

        AIResponseDTO ai = aiService.analyzeResume(bytes);

        Resume resume = new Resume();
        resume.setFileName(file.getOriginalFilename());
        resume.setContent(bytes);
        resume.setCreatedAt(LocalDateTime.now().toString());

        resume.setExtractedText(ai.getText());
        resume.setSkills(String.join(",", ai.getSkills()));
        resume.setScore((double) ai.getScore());

        resume.setJobMatches(ai.getJob_matches().toString());

        Resume saved = repository.save(resume);

        // 🔥 Convert to response DTO
        ResumeResponseDTO response = new ResumeResponseDTO();
        response.setId(saved.getId());
        response.setFileName(saved.getFileName());
        response.setScore(saved.getScore());
        response.setSkills(saved.getSkills());
        response.setJob_matches(ai.getJob_matches());

        return response;
    }

    public List<Resume> getAllResumes() {
        return repository.findAll();
    }
}