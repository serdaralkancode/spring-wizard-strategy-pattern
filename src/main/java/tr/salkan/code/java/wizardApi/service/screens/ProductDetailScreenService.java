package tr.salkan.code.java.wizardApi.service.screens;

import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.dto.BaseDTO;
import tr.salkan.code.java.wizardApi.dto.ProductDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;

@Service
public class ProductDetailScreenService implements IWizardScreenService {

    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        //id -> product table id
        //get info from database  or get from another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ProductDTO productDetailDTO = createProductDetailDTO(id);
        wizardScreenDTO.setProductDTO(productDetailDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createdProjectDetailDTO) {

        ProductDTO productDTO = createdProjectDetailDTO.getProductDTO();

        //save database or send another service get response

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ProductDTO createdProductDetailDTO = saveProductDetailDTO(productDTO);

        wizardScreenDTO.setProductDTO(createdProductDetailDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updatedProjectDTO) {

        ProductDTO productDTO = updatedProjectDTO.getProductDTO();

        //save database or send another service

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ProductDTO updatedProductDetailDTO = updateProductDetailDTO(productDTO);

        wizardScreenDTO.setProductDTO(updatedProductDetailDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardSceenEnum getScreenName() {
        return WizardSceenEnum.PRODUCT_DETAIL_SCREEN;
    }

    private ProductDTO createProductDetailDTO(Long id) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setProductDetail("product 1 detail info ");

        return productDTO;

    }

    private ProductDTO saveProductDetailDTO(ProductDTO productDTO) {

        Long id = 1l; // get productId
        ProductDTO createdDTO = new ProductDTO();
        createdDTO.setId(id);
        createdDTO.setProductDetail(productDTO.getProductDetail());

        //save database
        return createdDTO;

    }

    private ProductDTO updateProductDetailDTO(ProductDTO productDTO) {

        //update database
        return productDTO;
    }
}
