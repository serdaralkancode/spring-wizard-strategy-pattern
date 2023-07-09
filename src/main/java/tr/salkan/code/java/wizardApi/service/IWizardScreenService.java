package tr.salkan.code.java.wizardApi.service;

import tr.salkan.code.java.wizardApi.dto.BaseDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;

public interface IWizardScreenService {

    <T extends BaseDTO> T getWizard(Long id);

    <T extends BaseDTO> T createModelWizard(WizardScreenDTO createdWizardScreenDTO);

    <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateddWizardScreenDTO);

    WizardSceenEnum getScreenName();
}
