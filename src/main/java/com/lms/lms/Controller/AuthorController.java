/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Controller;

import com.lms.lms.Entity.Author;
import com.lms.lms.Service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 91962
 */
@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    AuthorService authorService;
    
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return "Author added successfully";
    }
    
    @GetMapping("/get_authors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }
}
