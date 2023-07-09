package tr.salkan.code.java.wizardApi.dto;

import lombok.Data;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.enums.WizardScreenRequestTypeEnum;

import java.io.Serializable;

@Data
public class WizardRequestDTO implements Serializable {

    private WizardSceenEnum sceenEnum;
    private WizardScreenRequestTypeEnum requestTypeEnum;
    private WizardScreenDTO wizardScreenDTO;
}
