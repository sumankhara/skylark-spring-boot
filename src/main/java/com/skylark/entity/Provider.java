package com.skylark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "agent_name", nullable = false, length = 50)
	private String agentName;
	
	@Column(nullable = false)
	private String branch;
	
	private int phone;
	
	public Provider() {
		
	}

	public Provider(String agentName, String branch, int phone) {
		super();
		this.agentName = agentName;
		this.branch = branch;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", agentName=" + agentName + ", branch=" + branch + ", phone=" + phone + "]";
	}

}
