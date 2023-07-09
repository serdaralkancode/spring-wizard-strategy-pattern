package tr.salkan.code.java.wizardApi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryDTO extends BaseDTO {

    private String categoryName;
}
