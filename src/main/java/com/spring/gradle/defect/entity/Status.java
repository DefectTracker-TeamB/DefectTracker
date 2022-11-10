package com.spring.gradle.defect.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_data")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status_name;
	private Date change_date;
	private Long defect_id;
	private Long user_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	
	public Date getChange_date() {
		return change_date;
	}
	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}
	public Long getDefect_id() {
		return defect_id;
	}
	public void setDefect_id(Long defect_id) {
		this.defect_id = defect_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Status [id=" + id + ", status_name=" + status_name + ", change_date=" + change_date + ", defect_id=" +defect_id
				+ ", user_id=" + user_id + "]";
	
	}

}
