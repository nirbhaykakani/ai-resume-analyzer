package com.example.resumeAnalyzer.service;

import com.example.resumeAnalyzer.dto.AIResponseDTO;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AIService {

    private final WebClient webClient = WebClient.create("http://localhost:8000");

    public AIResponseDTO analyzeResume(byte[] fileBytes) {

        return webClient.post()
                .uri("/analyze")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("file",
                        new ByteArrayResource(fileBytes) {
                            @Override
                            public String getFilename() {
                                return "resume.pdf";
                            }
                        }))
                .retrieve()
                .bodyToMono(AIResponseDTO.class)
                .block();
    }
}