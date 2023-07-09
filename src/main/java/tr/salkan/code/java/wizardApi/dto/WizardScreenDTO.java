package tr.salkan.code.java.wizardApi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class WizardScreenDTO extends BaseDTO {

    private ProductDTO productDTO;
    private CategoryDTO categoryDTO;
    private CompanyDTO companyDTO;
    private List<SpecificationDTO> specificationDTOList = new LinkedList<>();

}
