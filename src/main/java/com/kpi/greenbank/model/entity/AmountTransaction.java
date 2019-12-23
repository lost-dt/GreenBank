package com.kpi.greenbank.model.entity;

import java.util.Date;
import java.util.Objects;

public class AmountTransaction {

    private Integer id;
    private String userEmail;
    private Float amountValue;
    private TransactionStatus status;
    private Date creationTime;
    private String handledBy;
    private Date handledTime;

    public AmountTransaction() {

    }

    public AmountTransaction(
            Integer id,
            String userEmail,
            Float amountValue,
            TransactionStatus status,
            Date creationTime,
            String handledBy,
            Date handledTime) {
        this.id = id;
        this.userEmail = userEmail;
        this.amountValue = amountValue;
        this.status = status;
        this.creationTime = creationTime;
        this.handledBy = handledBy;
        this.handledTime = handledTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmountTransaction amountTransaction = (AmountTransaction) o;

        if (!Objects.equals(id, amountTransaction.id)) return false;
        if (!Objects.equals(userEmail, amountTransaction.userEmail)) return false;
        if (!Objects.equals(amountValue, amountTransaction.amountValue)) return false;
        if (!Objects.equals(status, amountTransaction.status)) return false;
        if (!Objects.equals(creationTime, amountTransaction.creationTime)) return false;
        if (!Objects.equals(handledBy, amountTransaction.handledBy)) return false;
        return Objects.equals(handledTime, amountTransaction.handledTime);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (amountValue != null ? status.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (handledBy != null ? handledBy.hashCode() : 0);
        result = 31 * result + (handledTime != null ? handledTime.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "AmountTransaction(" +
                "id=" + id +
                ", userEmail=" + '\'' + userEmail + '\'' +
                ", amountValue=" + '\'' + amountValue + '\'' +
                ", status=" + '\'' + status + '\'' +
                ", creationTime=" + '\'' + creationTime + '\'' +
                ", handledBy=" + '\'' + handledBy + '\'' +
                ", handledTime=" + '\'' + handledTime + '\'' +
                ')';
    }
}
