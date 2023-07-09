package tr.salkan.code.java.wizardApi.enums;

public enum WizardSceenEnum {

    PRODUCT_INFO_SCREEN(1,"ProductInfo","Entering infos of product base"),
    PRODUCT_DETAIL_SCREEN(2,"ProductDetail","Entering info of product details"),
    PRODUCT_CATEGORY_SCREEN(3,"ProductCategory","Entering category info of product"),
    PRODUCT_COMPANY_SCREEN(4,"ProductCompany","Entering company info of product"),
    PRODUCT_SPECIFICATION_SCREEN(5,"ProductSpecification","Entering specifications of product");

    private Integer order;
    private String screenKey;
    private String screenDescription;

    WizardSceenEnum(Integer order, String screenKey, String screenDescription) {
        this.order = order;
        this.screenKey = screenKey;
        this.screenDescription = screenDescription;
    }

    WizardSceenEnum findScreenByOrderId(Integer orderIndex)
    {
        for(WizardSceenEnum wizardSceenEnum : values())
        {
            if(wizardSceenEnum.getOrder().equals(orderIndex))
            {
                return wizardSceenEnum;
            }
        }

        return null;
    }

    WizardSceenEnum findScreenByKey(String key)
    {
        for(WizardSceenEnum wizardSceenEnum : values())
        {
            if(wizardSceenEnum.getScreenKey().equals(key))
            {
                return wizardSceenEnum;
            }
        }

        return null;
    }

    public Integer getOrder() {
        return order;
    }

    public String getScreenKey() {
        return screenKey;
    }

    public String getScreenDescription() {
        return screenDescription;
    }
}
