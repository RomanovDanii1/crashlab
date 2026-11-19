
package dev.crashlab.backend.analysis.dto;

import dev.crashlab.backend.analysis.Analysis;
import dev.crashlab.backend.analysis.AnalysisStatus;

import java.time.Instant;
import java.util.UUID;

public record AnalysisResponse(
        UUID id,
        String projectName,
        String repositoryUrl,
        AnalysisStatus status,
        Instant createdAt
) {

    public static AnalysisResponse from(Analysis analysis) {
        return new AnalysisResponse(
                analysis.id(),
                analysis.projectName(),
                analysis.repositoryUrl(),
                analysis.status(),
                analysis.createdAt()
        );
    }
}
