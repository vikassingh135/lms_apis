/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Service;

import com.lms.lms.Entity.Author;
import com.lms.lms.Repository.AuthorRepository;
import java.io.Serial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 91962
 */
@Service
public class AuthorService {
    
    @Autowired
    AuthorRepository authorRepository;
    
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
    
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
