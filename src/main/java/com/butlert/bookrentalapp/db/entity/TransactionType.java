package com.butlert.bookrentalapp.db.entity;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "TRANSACTION_TYPE")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_TYPE_ID")
    private Long id;

    @Column(name = "TRANSACTION_TYPE_NAME")
    private String transactionTypeName;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanConverter.class)
    private boolean activeFlag;

    public TransactionType() {
    }

    public TransactionType(Long id, String transactionTypeName, boolean activeFlag) {
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
