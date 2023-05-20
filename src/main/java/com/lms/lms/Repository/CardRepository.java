/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.Repository;

import com.lms.lms.Entity.LibraryCard;
import javax.smartcardio.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 91962
 */
@Repository
public interface CardRepository extends JpaRepository<LibraryCard, Integer>{
    
}
