
package dev.crashlab.backend.analysis;

import dev.crashlab.backend.analysis.dto.CreateAnalysisRequest;

import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;

@Service
public class AnalysisService {

    private final Clock clock;

    public AnalysisService(Clock clock) {
        this.clock = clock;
    }

    public Analysis createAnalysis(CreateAnalysisRequest request) {
        return new Analysis(
                UUID.randomUUID(),
                request.projectName().trim(),
                request.repositoryUrl().trim(),
                AnalysisStatus.PENDING,
                Instant.now(clock)
        );
    }
}
