package com.kpi.greenbank.model.entity;

public enum  UserBranch {

    EUROPE ("europe"),
    ASIA ("asia"),
    NORTH_AMERICA ("north america"),
    SOUTH_AMERICA ("south america"),
    AFRICA("africa"),
    AUSTRALIA("australia");

    private String title;

    UserBranch(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "UserBranch{" +
                "title='" + title + '\'' +
                '}';
    }
}
