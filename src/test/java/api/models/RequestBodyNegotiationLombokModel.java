package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestBodyNegotiationLombokModel {
    @JsonProperty("vacancy_id")
    String vacancyId;

    @JsonProperty("resume_id")
    String resumeId;
    String message;
}