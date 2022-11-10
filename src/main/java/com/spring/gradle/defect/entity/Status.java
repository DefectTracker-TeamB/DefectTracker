package com.spring.gradle.defect.entity;

//package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_data")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status_name;
	private String change_date;

	// Mapping

//			@ManyToMany(targetEntity = User.class,fetch = FetchType.EAGER)
//		    @JoinColumn(name = "id",nullable =false)
//		    private List<User> user;
//			 
	//
	//
//		 	@ManyToOne(targetEntity = Defect.class,fetch = FetchType.EAGER)
//		    @JoinColumn(name = "id",nullable =false)
//		    private List<Defect> defect;
	//
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

	public String getChange_date() {
		return change_date;
	}

	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Mapping

//			public List<User> getUser() {
//				return user;
//			}
//			public void setUser(List<User> user) {
//				this.user = user;
//			}
//			public List<Defect> getDefect() {
//				return defect;
//			}
//			public void setDefect(List<Defect> defect) {
//				this.defect = defect;
//			}

	// mapping
	// private Defect defect;
	// private User user;

	public Status() {
		super();
	}

	public Status(Long id, String status_name, String change_date) {
		super();
		this.id = id;
		this.status_name = status_name;
		this.change_date = change_date;
	}

}
