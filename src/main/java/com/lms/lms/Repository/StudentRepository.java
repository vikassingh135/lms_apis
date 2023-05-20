/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Repository;

import com.lms.lms.Entity.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 91962
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
    Student findByEmail(String emai);
    List<Student> findByAge(int age);
}
