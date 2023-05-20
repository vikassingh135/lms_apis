/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Repository;

import com.lms.lms.Entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 91962
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
    
    
    @Query(value = "select * from transaction t where t.card_card_no=:cardId and  t.transaction_status='SUCCESS'", nativeQuery = true)
    List<Transaction> getAllSuccessfullTxnsWithCardNo(int cardId);
}
