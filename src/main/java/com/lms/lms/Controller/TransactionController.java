/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Controller;

import com.lms.lms.DTO.IssueBookRequestDto;
import com.lms.lms.DTO.IssueBookResponseDto;
import com.lms.lms.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 91962
 */
@RestController
@RequestMapping
public class TransactionController {
    
    @Autowired
    TransactionService transactionService;
    
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) {
        IssueBookResponseDto issueBookResponseDto;
        try{
            issueBookResponseDto = transactionService.issuBook(issueBookRequestDto);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        
        return new ResponseEntity(issueBookResponseDto, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/get")
    public String getAllTxns(@RequestParam int cardId) {
        return transactionService.getAllTxns(cardId);
    }
}
