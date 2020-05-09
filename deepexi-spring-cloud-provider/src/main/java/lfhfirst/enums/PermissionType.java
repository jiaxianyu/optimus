package lfhfirst.enums;

public enum PermissionType {
    PERMEUN("menu"),
    PERAPI("api");

    private String type;

    PermissionType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
