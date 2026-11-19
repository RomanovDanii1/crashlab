
package dev.crashlab.backend.analysis;

import dev.crashlab.backend.analysis.dto.CreateAnalysisRequest;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisServiceTest {

    private final Instant fixedTime =
            Instant.parse("2026-11-19T12:00:00Z");

    private final Clock clock =
            Clock.fixed(fixedTime, ZoneOffset.UTC);

    private final AnalysisService service =
            new AnalysisService(clock);

    @Test
    void shouldCreatePendingAnalysis() {
        // Arrange
        CreateAnalysisRequest request =
                new CreateAnalysisRequest(
                        "demo-project",
                        "https://github.com/example/demo"
                );

        // Act
        Analysis result = service.createAnalysis(request);

        // Assert
        assertNotNull(result.id());
        assertEquals("demo-project", result.projectName());
        assertEquals(
                "https://github.com/example/demo",
                result.repositoryUrl()
        );
        assertEquals(AnalysisStatus.PENDING, result.status());
        assertEquals(fixedTime, result.createdAt());
    }
}
