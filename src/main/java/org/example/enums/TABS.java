package org.example.enums;

public enum TABS{
    GENERAL(0),
    DASHBOARD(1),
    ADDITIONAL(2),
    SKU_GROUPS(3),
    LAYOUT(4),
    EXCHANGE(5),
    IMPORT(6),
    EXPORT(7),
    ORDERS(8),
    FRESH(9),
    QLIK(10),
    API(11),
    BILLIING(12),
    CDA(13),
    ADU(14),
    PROMO_TOOLS(15),
    SIMILAR_PRODUCTS(16),
    FORECAST(17);

    private int value;
    TABS(int i) {
        this.value = i;
    }

    public int getValue(){
        return this.value;
    }
}