package com.butlert.bookrentalapp.db.entity.rental;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "transaction_status")
public class TransactionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_STATUS_ID")
    private Long id;

    @Column(name = "TRANSACTION_STATUS_NAME")
    private String transactionStatusName;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanConverter.class)
    private boolean activeFlag;

    public TransactionStatus() {
    }

    public TransactionStatus(Long id, String transactionStatusName, boolean activeFlag) {
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

    public void setTransactionStatusName(String transactionStatus) {
        this.transactionStatusName = transactionStatus;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
