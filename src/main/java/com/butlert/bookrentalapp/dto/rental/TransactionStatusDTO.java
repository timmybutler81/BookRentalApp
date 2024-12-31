package com.butlert.bookrentalapp.dto.rental;

public class TransactionStatusDTO {

    private Long id;
    private String transactionStatusName;
    private boolean activeFlag;

    public TransactionStatusDTO() {
    }

    public TransactionStatusDTO(Long id, String transactionStatusName, boolean activeFlag) {
        this.id = id;
        this.transactionStatusName = transactionStatusName;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionStatusName() {
        return transactionStatusName;
    }

    public void setTransactionStatusName(String transactionStatusName) {
        this.transactionStatusName = transactionStatusName;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
