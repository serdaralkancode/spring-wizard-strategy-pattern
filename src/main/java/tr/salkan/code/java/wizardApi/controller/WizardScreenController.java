package tr.salkan.code.java.wizardApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.salkan.code.java.wizardApi.dto.WizardRequestDTO;
import tr.salkan.code.java.wizardApi.dto.WizardScreenDTO;
import tr.salkan.code.java.wizardApi.enums.WizardSceenEnum;
import tr.salkan.code.java.wizardApi.service.IWizardService;

@RestController
@RequestMapping("wizard-controller")
public class WizardScreenController {

    private final IWizardService wizardService;

    @Autowired
    public WizardScreenController(IWizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping("/getWizard")
    public ResponseEntity<WizardScreenDTO> getWizard(@RequestParam Long id, @RequestParam WizardSceenEnum wizardSceenEnum)
    {
        return wizardService.getWizard(id,wizardSceenEnum);
    }

    @PostMapping(value = "postWizard")
    public ResponseEntity<WizardScreenDTO> postWizard(@RequestBody WizardRequestDTO wizardRequestDTO)
    {
        return wizardService.postWizard(wizardRequestDTO);
    }


}
