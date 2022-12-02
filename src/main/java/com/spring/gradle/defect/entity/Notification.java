package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="notification_data")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String content;
	private String to_whome;
	@ManyToOne
	@JoinColumn(name = "defect_Id",nullable = false)
	private Defect defect;


	public Notification() {

	}
	public Notification(String content) {
		 this.content = content;
	}
	
	
	

	
	
	

}
