/**
 * 
 */
package com.sogeti.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author skarpe
 *
 */
@Entity
@Table (name="TEAM")
@XmlRootElement
public class TeamDetails implements Serializable {
	
	public TeamDetails() {
		
	}
	
	public TeamDetails(int employee_id, String employee_name, int amount, String month, Date date) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.amount = amount;
		this.month = month;
		this.date = date;
	}

	@Id
	private int employee_id;
	
	private String employee_name;
	
	private int amount;
	
	private String month;
	
	private Date date;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
