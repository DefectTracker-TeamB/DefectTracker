package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notification_data")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "defect_Id",nullable = false)
	private Defect defect;
	
	public Defect getDefect() {
		return defect;
	}

	public void setDefect(Defect defect) {
		this.defect = defect;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Notification() {
		
	}

	public Notification(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Notification(String string) {
		// TODO Auto-generated constructor stub
	}
	
	

}
