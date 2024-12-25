package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.TransactionTypeDAO;
import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.db.mapper.TransactionTypeMapper;
import com.butlert.bookrentalapp.dto.TransactionTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {

   @Autowired
   private TransactionTypeDAO transactionTypeDAO;

   public List<TransactionTypeDTO> getAllTransactionTypes() {
       return transactionTypeDAO.findAllTransactionTypes();
   }

   public TransactionTypeDTO getTransactionTypeById(Long id) {
       return transactionTypeDAO.findTransactionTypeById(id);
   }

   public TransactionTypeDTO saveTransactionType (TransactionTypeDTO transactionTypeDTO) {
       TransactionType transactionType = TransactionTypeMapper.toEntity(transactionTypeDTO);
       return transactionTypeDAO.saveTransactionType(transactionType);
   }
}
