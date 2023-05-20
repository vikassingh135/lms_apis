/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lms.lms.DTO;

import com.lms.lms.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 91962
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {

        private String title;
        
        private int price;
        
        private Genre genre;
        
        private int authorid;
    
}



