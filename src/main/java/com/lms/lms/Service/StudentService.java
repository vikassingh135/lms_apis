/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Service;

import com.lms.lms.DTO.StudentRequestDto;
import com.lms.lms.DTO.StudentResponseDto;
import com.lms.lms.DTO.StudentUpdateEmailRequestDto;
import com.lms.lms.Entity.LibraryCard;
import com.lms.lms.Entity.Student;
import com.lms.lms.Enum.CardStatus;
import com.lms.lms.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 91962
 */
@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;
    
    public void addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());
        
        LibraryCard card = new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);
        
        student.setCard(card);
        
        studentRepository.save(student);
    }
    
    public String findByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }
    
    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto) {
        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());
        
        Student updatedStudent = studentRepository.save(student);
        
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());
        
        return studentResponseDto;
    }
}
