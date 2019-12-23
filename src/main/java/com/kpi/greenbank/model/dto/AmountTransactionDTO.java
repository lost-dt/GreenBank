package com.kpi.greenbank.model.dto;

import com.kpi.greenbank.model.entity.TransactionStatus;

import java.util.Date;

public class AmountTransactionDTO {

    private Integer id;
    private String userEmail;
    private Float amountValue;
    private TransactionStatus status;
    private Date creationTime;
    private String handledBy;
    private Date handledTime;

    private AmountTransactionDTO(Builder builder) {
        id = builder.id;
        userEmail = builder.userEmail;
        amountValue = builder.amountValue;
        status = builder.status;
        creationTime = builder.creationTime;
        handledBy = builder.handledBy;
        handledTime = builder.handledTime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Float getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(Float amountValue) {
        this.amountValue = amountValue;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(String handledBy) {
        this.handledBy = handledBy;
    }

    public Date getHandledTime() {
        return handledTime;
    }

    public void setHandledTime(Date handledTime) {
        this.handledTime = handledTime;
    }

    public static class Builder {

        private Integer id;
        private String userEmail;
        private Float amountValue;
        private TransactionStatus status;
        private Date creationTime;
        private String handledBy;
        private Date handledTime;

        public Builder() {

        }

        public Builder setId(Integer id) {
            this.id = id;

            return this;
        }

        public Builder setUserEmail(String userEmail) {
            this.userEmail = userEmail;

            return this;
        }

        public Builder setAmountValue(Float amountValue) {
            this.amountValue = amountValue;

            return this;
        }

        public Builder setStatus(TransactionStatus status) {
            this.status = status;

            return this;
        }

        public Builder setCreationTime(Date creationTime) {
            this.creationTime = creationTime;

            return this;
        }

        public Builder setHandledBy(String handledBy) {
            this.handledBy = handledBy;

            return this;
        }

        public Builder setHandledTime(Date handledTime) {
            this.handledTime = handledTime;

            return this;
        }




        public AmountTransactionDTO build() {
            return new AmountTransactionDTO(this);
        }

    }
}
