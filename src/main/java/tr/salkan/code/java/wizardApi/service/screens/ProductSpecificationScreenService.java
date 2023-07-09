package tr.salkan.code.java.wizardApi.service.screens;

import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.dto.BaseDTO;
import tr.salkan.code.java.wizardApi.dto.ProductDTO;
import tr.salkan.code.java.wizardApi.dto.SpecificationDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductSpecificationScreenService implements IWizardScreenService {

    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        //id -> product table id
        //get info from database with  or another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        List<SpecificationDTO> specificationDTOList = createProductSpecificationList();
        wizardScreenDTO.setSpecificationDTOList(specificationDTOList);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createdProjectSpecDTO) {

        ProductDTO productDTO = createdProjectSpecDTO.getProductDTO();

        List<SpecificationDTO> createSpecificationDTOList =  createdProjectSpecDTO.getSpecificationDTOList();

        AtomicLong counter = new AtomicLong(100);

        createSpecificationDTOList.forEach(specificationDTO -> {
            specificationDTO.setId(counter.getAndIncrement());
        });

        //save product specification table with createSpecificationDTOList

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setProductDTO(productDTO);
        wizardScreenDTO.setSpecificationDTOList(createSpecificationDTOList);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updatedProjectSpecDTO) {

        ProductDTO productDTO = updatedProjectSpecDTO.getProductDTO();

        List<SpecificationDTO> updateSpecificationDTOList =  updatedProjectSpecDTO.getSpecificationDTOList();

        //update product specification table with updateSpecificationDTOList

        updateSpecificationDTOList.forEach(specificationDTO -> {

            specificationDTO.setDescription(specificationDTO + " updated");
        });

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setProductDTO(productDTO);
        wizardScreenDTO.setSpecificationDTOList(updateSpecificationDTOList);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardSceenEnum getScreenName() {
        return WizardSceenEnum.PRODUCT_SPECIFICATION_SCREEN;
    }

    private List<SpecificationDTO> createProductSpecificationList() {

        List<SpecificationDTO> list = new ArrayList<>();

        SpecificationDTO dto1 = createSpecificationDTO(300l,"spec 1");
        SpecificationDTO dto2 = createSpecificationDTO(400l,"spec 2");

        list.add(dto1);
        list.add(dto2);

        return list;

    }

    private SpecificationDTO createSpecificationDTO(Long specId, String specName) {

        SpecificationDTO dto = new SpecificationDTO();
        dto.setId(specId);
        dto.setDescription(specName);

        return dto;
    }
}
