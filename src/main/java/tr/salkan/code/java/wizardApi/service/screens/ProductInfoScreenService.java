package tr.salkan.code.java.wizardApi.service.screens;

import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.dto.BaseDTO;
import tr.salkan.code.java.wizardApi.dto.ProductDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;

@Service
public class ProductInfoScreenService implements IWizardScreenService {

    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        //id -> product table id
        //get info from database  or get another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ProductDTO productDTO = createProductDTO(id);

        wizardScreenDTO.setProductDTO(productDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createdProjectDTO) {

        ProductDTO productDTO = createdProjectDTO.getProductDTO();

        //save dto for entity or send another service get response

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ProductDTO createdProductDTO = saveProductDTO(productDTO);

        wizardScreenDTO.setProductDTO(createdProductDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updatedProjectDTO) {

        ProductDTO productDTO = updatedProjectDTO.getProductDTO();

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ProductDTO updatedProductDTO = updateProductDTO(productDTO);

        wizardScreenDTO.setProductDTO(updatedProductDTO);
        return (T) wizardScreenDTO;
    }

    @Override
    public WizardSceenEnum getScreenName() {
        return WizardSceenEnum.PRODUCT_INFO_SCREEN;
    }

    private ProductDTO createProductDTO(Long id) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setProductName("product 1");
        productDTO.setProductCode("p1");
        productDTO.setProductTitle("product1 title");

        return productDTO;
    }

    private ProductDTO saveProductDTO(ProductDTO productDTO) {

        ProductDTO createdDTO = new ProductDTO();
        createdDTO.setProductName(productDTO.getProductName());
        createdDTO.setProductCode(productDTO.getProductCode());
        createdDTO.setProductTitle(productDTO.getProductTitle());

        //save database
        createdDTO.setId(2l);
        return createdDTO;
    }

    private ProductDTO updateProductDTO(ProductDTO productDTO) {

        //update database
        return productDTO;
    }
}
