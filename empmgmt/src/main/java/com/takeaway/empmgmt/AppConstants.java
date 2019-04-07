package com.takeaway.empmgmt;

public enum AppConstants {

    TOPIC("employee"),
    GROUP_ID("EMPMGMT");

    private String value;
    private AppConstants(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
