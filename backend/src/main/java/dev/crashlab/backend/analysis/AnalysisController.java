package dev.crashlab.backend.analysis;

import dev.crashlab.backend.analysis.dto.AnalysisResponse;
import dev.crashlab.backend.analysis.dto.CreateAnalysisRequest;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/analyses")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public ResponseEntity<AnalysisResponse> createAnalysis(
            @Valid @RequestBody CreateAnalysisRequest request
    ) {
        Analysis analysis = analysisService.createAnalysis(request);

        return ResponseEntity
                .created(URI.create("/api/v1/analyses/" + analysis.id()))
                .body(AnalysisResponse.from(analysis));
    }
}