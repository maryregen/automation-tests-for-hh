package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForbiddenResponseModel {
    String request_id;
    String description;
    ForbiddenErrorResponseModel[] errors;
    String oauth_error;
}
