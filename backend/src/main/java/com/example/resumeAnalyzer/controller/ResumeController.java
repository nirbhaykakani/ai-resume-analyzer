package com.example.resumeAnalyzer.controller;

import com.example.resumeAnalyzer.dto.ResumeResponseDTO;
import com.example.resumeAnalyzer.entity.Resume; // Your Resume model
import com.example.resumeAnalyzer.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:3000")
public class ResumeController {

    private final ResumeService service;

    public ResumeController(ResumeService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file) {
        try {
            ResumeResponseDTO response = service.saveResume(file);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = service.getAllResumes();
        return ResponseEntity.ok(resumes);
    }
}