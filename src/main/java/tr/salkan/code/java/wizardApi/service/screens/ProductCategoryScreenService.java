package tr.salkan.code.java.wizardApi.service.screens;

import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.dto.BaseDTO;
import tr.salkan.code.java.wizardApi.dto.CategoryDTO;
import tr.salkan.code.java.wizardApi.dto.ProductDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;

@Service
public class ProductCategoryScreenService implements IWizardScreenService {
    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        //id -> product table id or category id
        //get info from database  or get another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(2l);
        categoryDTO.setCategoryName("Category 1");

        wizardScreenDTO.setCategoryDTO(categoryDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createdCategoryDTO) {

        CategoryDTO createCategory = createdCategoryDTO.getCategoryDTO();
        ProductDTO productDTO = createdCategoryDTO.getProductDTO();

        // save product table with category in database or send another service get response

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setProductDTO(productDTO);
        wizardScreenDTO.setCategoryDTO(createCategory);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updatedCategoryDTO) {

        CategoryDTO updateCategory = updatedCategoryDTO.getCategoryDTO();
        ProductDTO productDTO = updatedCategoryDTO.getProductDTO();

        //update product with category in database or send another service get response
        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setProductDTO(productDTO);
        wizardScreenDTO.setCategoryDTO(updateCategory);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardSceenEnum getScreenName() {
        return WizardSceenEnum.PRODUCT_CATEGORY_SCREEN;
    }
}
