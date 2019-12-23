package com.kpi.greenbank.model.entity;

public enum TransactionStatus {
    WAIT("wait"),
    ASSEPT("assept"),
    CLOSE("close");

    private String title;

    TransactionStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
                "title='" + title + '\'' +
                '}';
    }
}
