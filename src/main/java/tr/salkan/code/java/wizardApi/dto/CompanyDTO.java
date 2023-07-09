package tr.salkan.code.java.wizardApi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CompanyDTO extends BaseDTO {

    private String companyName;
}
