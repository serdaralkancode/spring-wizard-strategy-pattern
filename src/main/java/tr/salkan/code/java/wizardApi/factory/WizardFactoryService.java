package tr.salkan.code.java.wizardApi.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardScreenService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class WizardFactoryService {

    private Map<WizardSceenEnum, IWizardScreenService> wizardScreens;

    @Autowired
    public WizardFactoryService(Set<IWizardScreenService> IWizardScreenServiceSet)
    {
        createScreenWizard(IWizardScreenServiceSet);
    }

    public IWizardScreenService getScreenWizard(WizardSceenEnum wizardSceenEnum)
    {
        return wizardScreens.get(wizardSceenEnum);
    }

    private void createScreenWizard(Set<IWizardScreenService> IWizardScreenServiceSet) {

        wizardScreens = new HashMap<>();
        IWizardScreenServiceSet.forEach(projectWizardService -> wizardScreens.put(projectWizardService.getScreenName(),projectWizardService));
    }
}
