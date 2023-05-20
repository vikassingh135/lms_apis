/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Service;

import com.lms.lms.DTO.IssueBookRequestDto;
import com.lms.lms.DTO.IssueBookResponseDto;
import com.lms.lms.Entity.Book;
import com.lms.lms.Entity.LibraryCard;
import com.lms.lms.Entity.Transaction;
import com.lms.lms.Enum.CardStatus;
import com.lms.lms.Enum.TransactionStatus;
import com.lms.lms.Repository.BookRepository;
import com.lms.lms.Repository.CardRepository;
import com.lms.lms.Repository.TransactionRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 91962
 */
@Service
public class TransactionService {
    
    @Autowired
    CardRepository cardRepository;
    
    
    @Autowired
    TransactionRepository transactionRepository;
    
    @Autowired
    BookRepository bookRepository;
    
    public IssueBookResponseDto issuBook(IssueBookRequestDto issueBookRequesetDto) throws Exception {
        
        // create transaction object;
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);
        
        //1st step
        LibraryCard card;
        try{
            card = cardRepository.findById(issueBookRequesetDto.getCardId()).get();
            
        } catch(Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Card Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id");
        }
        
        Book book;
        try{
            book = bookRepository.findById(issueBookRequesetDto.getBookId()).get();
        } catch(Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book id");
        }
        
        transaction.setBook(book);
        transaction.setCard(card);
        
        if(card.getStatus() != CardStatus.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not activated");
        }
        
        if(book.isIssued()) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry! Book is already issued.");
            transactionRepository.save(transaction);
            throw new Exception("Sorry! Book is already issued");
        }
        
        // i can issue the book
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transation Successfull");
        
        book.setIssued(true);
        book.setCard(card);
        book.getTransactions().add(transaction);
        card.getTransactions().add(transaction);
        card.getBooksIssued().add(book);
        
        cardRepository.save(card);
        
        // Prepare Response Dto
        IssueBookResponseDto issuBookResponseDto = new IssueBookResponseDto();
        
        issuBookResponseDto.setTransactionId(transaction.getTransactionNumber());
        issuBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issuBookResponseDto.setBookName(book.getTitle());
        
        return issuBookResponseDto;
    }
    
    public String getAllTxns(int cardId) {
        List<Transaction> transactionList = transactionRepository.getAllSuccessfullTxnsWithCardNo(cardId);
        String ans = "";
        for(Transaction t : transactionList) {
            ans += t.getTransactionNumber();
            ans += "\n";
        }
        return ans;
    }
}
