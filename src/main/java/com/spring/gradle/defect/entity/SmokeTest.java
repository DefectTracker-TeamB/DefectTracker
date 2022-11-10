package com.spring.gradle.defect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SmokeTest", catalog = "defect_tracker")
public class SmokeTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "post_by")
	private String post_by;

	@Column(name = "status")
	private String status;
	@Column(name = "description")
	private String description;
	
	//entity
//	
//	@OneToOne(targetEntity = Release.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "id",nullable =false)
//	private Release release;
	
	
	public SmokeTest() {
		super();
	}
	public SmokeTest(Long id, String post_by, String status, String description) {
		super();
		this.id = id;
		this.post_by = post_by;
		this.status = status;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPost_by() {
		return post_by;
	}
	public void setPost_by(String post_by) {
		this.post_by = post_by;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//entity
//	public Release getRelease() {
//		return release;
//	}
//	public void setRelease(Release release) {
//		this.release = release;
//	}
//	
	
	
	
	
}
