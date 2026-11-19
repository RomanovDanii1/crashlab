package dev.crashlab.backend.analysis;

import java.time.Instant;
import java.util.UUID;

public record Analysis(
        UUID id,
        String projectName,
        String repositoryUrl,
        AnalysisStatus status,
        Instant createdAt
) {
}