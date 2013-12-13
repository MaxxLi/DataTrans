/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.exception;

/**
 *
 * @author AUG
 */
public class AppException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public AppException(String message) {
		this.message=message;	
	}
		
	@Override
	public String getMessage() {	
		return this.message;
	}
}

