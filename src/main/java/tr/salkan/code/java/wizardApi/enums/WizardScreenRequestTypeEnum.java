package tr.salkan.code.java.wizardApi.enums;

public enum WizardScreenRequestTypeEnum {

    CREATE("CREATE"),
    UPDATE("UPDATE");

    private String requestType;

    WizardScreenRequestTypeEnum( String requestType) {
        this.requestType = requestType;
    }

    WizardScreenRequestTypeEnum getScreenRequestTypeByKey(String key)
    {
        for (WizardScreenRequestTypeEnum wizardScreenRequestTypeEnum: values())
        {
            if(wizardScreenRequestTypeEnum.getRequestType().equals(key))
            {
                return wizardScreenRequestTypeEnum;
            }
        }

        return null;
    }

    public String getRequestType() {
        return requestType;
    }
}
