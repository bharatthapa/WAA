/**
 * 
 */
package com.students.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Range;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Range(min=100,max=999,message="{SIZE.phone}")
 	private int area;
	
	@Range(min=100,max=999,message="{SIZE.phone}")
 	private int prefix;
	
	@Range(min=1000,max=9999,message="{SIZE.phone}")
 	private int number;
	

 
	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

 	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
}
