package tr.salkan.code.java.wizardApi.service;

import org.springframework.http.ResponseEntity;
import tr.salkan.code.java.wizardApi.dto.WizardRequestDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;

public interface IWizardService {

    ResponseEntity<WizardScreenDTO> postWizard(WizardRequestDTO wizardRequestDTO);

    ResponseEntity<WizardScreenDTO> getWizard(Long id, WizardSceenEnum wizardSceenEnum);
}
