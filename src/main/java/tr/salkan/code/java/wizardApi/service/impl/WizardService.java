package tr.salkan.code.java.wizardApi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.dto.WizardRequestDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.enums.WizardScreenRequestTypeEnum;
import tr.salkan.code.java.wizardApi.factory.WizardFactoryService;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;
import tr.salkan.code.java.wizardApi.service.IWizardService;

import java.util.Objects;

@Service
public class WizardService implements IWizardService {

    private final WizardFactoryService wizardFactoryService;

    @Autowired
    public WizardService(WizardFactoryService wizardFactoryService) {
        this.wizardFactoryService = wizardFactoryService;
    }

    @Override
    public ResponseEntity<WizardScreenDTO> postWizard(WizardRequestDTO wizardRequestDTO) {

        IWizardScreenService wizardScreenService =  wizardFactoryService.getScreenWizard(wizardRequestDTO.getSceenEnum());

        if(wizardRequestDTO.getRequestTypeEnum().getRequestType().equals(WizardScreenRequestTypeEnum.CREATE.getRequestType()))
        {
            /**
             * create
             */

            WizardScreenDTO createdDTO =  wizardScreenService.createModelWizard(wizardRequestDTO.getWizardScreenDTO());
            return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
        }
        else if(wizardRequestDTO.getRequestTypeEnum().getRequestType().equals(WizardScreenRequestTypeEnum.UPDATE.getRequestType()))
        {
            /**
             * update
             */
            WizardScreenDTO updatedDTO = wizardScreenService.updateModelWizard(wizardRequestDTO.getWizardScreenDTO());
            return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(new WizardScreenDTO(), HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<WizardScreenDTO> getWizard(Long id, WizardSceenEnum wizardSceenEnum) {

        if(Objects.nonNull(id))
        {
            IWizardScreenService wizardScreenService =  wizardFactoryService.getScreenWizard(wizardSceenEnum);
            WizardScreenDTO wizardScreenDTO =  wizardScreenService.getWizard(id);

            return new ResponseEntity<>(wizardScreenDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(new WizardScreenDTO(), HttpStatus.BAD_REQUEST);
    }
}
