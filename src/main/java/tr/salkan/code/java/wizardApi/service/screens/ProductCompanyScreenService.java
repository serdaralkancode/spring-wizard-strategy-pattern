package tr.salkan.code.java.wizardApi.service.screens;

import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.dto.BaseDTO;
import tr.salkan.code.java.wizardApi.dto.CompanyDTO;
import tr.salkan.code.java.wizardApi.dto.ProductDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;

@Service
public class ProductCompanyScreenService implements IWizardScreenService {

    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        //id -> product table id or company id
        //get info from database  or get another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(100l);
        companyDTO.setCompanyName("Company 100");

        wizardScreenDTO.setCompanyDTO(companyDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createdCompanyDTO) {

        CompanyDTO createCompany = createdCompanyDTO.getCompanyDTO();
        ProductDTO productDTO = createdCompanyDTO.getProductDTO();

        // save product table with category in database or send another service get response

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setProductDTO(productDTO);
        wizardScreenDTO.setCompanyDTO(createCompany);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updatedCompanyDTO) {

        CompanyDTO updateCompany= updatedCompanyDTO.getCompanyDTO();
        ProductDTO productDTO = updatedCompanyDTO.getProductDTO();

        //update product with category in database or send another service get response
        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setProductDTO(productDTO);
        wizardScreenDTO.setCompanyDTO(updateCompany);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardSceenEnum getScreenName() {
        return WizardSceenEnum.PRODUCT_COMPANY_SCREEN;
    }
}
