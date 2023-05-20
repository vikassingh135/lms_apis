/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Controller;

import com.lms.lms.DTO.StudentRequestDto;
import com.lms.lms.DTO.StudentResponseDto;
import com.lms.lms.DTO.StudentUpdateEmailRequestDto;
import com.lms.lms.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 91962
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.addStudent(studentRequestDto);
        return "Student has been added";
    }
    
    @GetMapping("/find_by_email")
    public String findStudentByEmail(@RequestParam String email) {
        return studentService.findByEmail(email);
    }
    
    @PutMapping("/update_eamil")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto) {
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
