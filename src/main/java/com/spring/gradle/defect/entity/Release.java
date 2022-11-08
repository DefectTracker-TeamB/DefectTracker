package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "release", catalog = "defect_tracker")
public class Release implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "release_version")
	private String releaseVersion ;
	
	@Column(name = "api_link")
	private String apiLink ;
	
	@Column(name = "upload_file")
	private String uploadFile ;

	public Release() {
		super();
	}

	public Release(int id, String releaseVersion, String apiLink, String uploadFile) {
		super();
		this.id = id;
		this.releaseVersion = releaseVersion;
		this.apiLink = apiLink;
		this.uploadFile = uploadFile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReleaseVersion() {
		return releaseVersion;
	}

	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}

	public String getApiLink() {
		return apiLink;
	}

	public void setApiLink(String apiLink) {
		this.apiLink = apiLink;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", releaseVersion=" + releaseVersion + ", apiLink=" + apiLink + ", uploadFile="
				+ uploadFile + "]";
	}
}
