package com.butlert.bookrentalapp.dto;

public class TransactionTypeDTO {
    private Long id;
    private String transactionTypeName;
    private boolean activeFlag;

    public TransactionTypeDTO() {
    }

    public TransactionTypeDTO(Long id, String transactionTypeName, boolean activeFlag) {
        this.id = id;
        this.transactionTypeName = transactionTypeName;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
