/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhjava.service;


import com.laptrinhjava.model.Category;


public interface ICategoryService {
     Category save (Category save);
     Category update (Category update);
     void delete (Integer[] ids);
     
}
