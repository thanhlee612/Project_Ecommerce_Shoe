/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhjava.model;

/**
 *
 * @author ASUS
 */
public class Category {

	private int idCategory;
	private String cName;
	private Integer[] idCates;

	
	public Category() {
	}

	public Category(int idCategory, String cName) {
		this.idCategory = idCategory;
		this.cName = cName;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	public Integer[] getIdCates() {
		return idCates;
	}

	public void setIdCates(Integer[] idCates) {
		this.idCates = idCates;
	}

}
