/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Service;

import com.lms.lms.DTO.BookRequestDto;
import com.lms.lms.DTO.BookResponseDto;
import com.lms.lms.Entity.Author;
import com.lms.lms.Entity.Book;
import com.lms.lms.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 91962
 */
@Service
public class BookService {
    
    @Autowired
    AuthorRepository authorRepository;
    
  
    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {
        
        
        //get the authro object;
        Author author = authorRepository.findById(bookRequestDto.getAuthorid()).get();
        
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        author.getBook().add(book);
        authorRepository.save(author);
        
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());
        
        return bookResponseDto;
        
    }
    
}
