package com.laptrinhjava.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String value;// gan gia tri json vao value khi BufferedReader doc du lieu json

	public HttpUtil(String value) {
		this.value = value;
	}

	// json -> String
	public static HttpUtil offf(BufferedReader reader) {// BufferedReader doc du lieu tu json
		StringBuilder sb = new StringBuilder();//StringBuilder trong Java được sử dụng để tạo chuỗi có thể thay đổi (chuỗi dạng mutable)
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append( line);	
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
	
	/*
	 * public static int[] of(BufferedReader reader) { int[] ids = null; Integer
	 * line; try { while ((line = reader.read()) != -1) { ids = new int[line]; } }
	 * catch (IOException e) { System.out.print(e.getMessage()); } return ids;
	 * 
	 * }
	 */
	// binding to model
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (IOException e) {
		
			e.printStackTrace();
		}// readValue map gia tri từ json sau khi duoc chuyen doi sang java object vao class model
		return null;
	}
	
	
}
