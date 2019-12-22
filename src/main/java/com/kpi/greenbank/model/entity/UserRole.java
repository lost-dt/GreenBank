package com.kpi.greenbank.model.entity;

public enum UserRole {

    USER ("user"),
    MANAGER ("manager");

    private String title;

    UserRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "title='" + title + '\'' +
                '}';
    }
}
