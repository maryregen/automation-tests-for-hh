package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateResponseItemsModel {
    String name;
    CreateResponseItemsAreaModel area;

}
