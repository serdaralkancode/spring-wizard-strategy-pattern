package tr.salkan.code.java.wizardApi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDTO extends BaseDTO {

    private String productName;
    private String productCode;
    private String productTitle;
    private String productDetail;
}
