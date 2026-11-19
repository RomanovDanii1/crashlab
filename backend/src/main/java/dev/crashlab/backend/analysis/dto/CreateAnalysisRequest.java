
package dev.crashlab.backend.analysis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAnalysisRequest(

        @NotBlank(message = "Project name is required")
        @Size(max = 100, message = "Project name must not exceed 100 characters")
        String projectName,

        @NotBlank(message = "Repository URL is required")
        @Size(max = 2048, message = "Repository URL is too long")
        String repositoryUrl

) {
}
