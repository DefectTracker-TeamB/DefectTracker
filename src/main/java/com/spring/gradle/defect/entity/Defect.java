package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "defect_data")
public class Defect implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String module;
	private String found_in;
	private String fixed_in;
	private String type;
	private String severity;
	private String priority;
	private String Assign_to;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getFound_in() {
		return found_in;
	}
	public void setFound_in(String found_in) {
		this.found_in = found_in;
	}
	public String getFixed_in() {
		return fixed_in;
	}
	public void setFixed_in(String fixed_in) {
		this.fixed_in = fixed_in;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssign_to() {
		return Assign_to;
	}
	public void setAssign_to(String assign_to) {
		Assign_to = assign_to;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Defect [id=" + id + ", description=" + description + ", module=" + module + ", found_in=" +found_in
				+ ", fixed_in=" + fixed_in +", type=" + type +", severity=" + severity +", priority=" + priority +", Assign_to=" + Assign_to + "]";
	}
	

}
