package com.ahi.entity;

import java.security.Principal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ahi_client")
public class AhiClients {
	
	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "client_desc")
	private String clientDesc;
	
	@Column(name = "client_location")
	private String clientLocation;
	
	@Column(name = "who_updated")
	private String whoUpdated;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientDesc() {
		return clientDesc;
	}

	public void setClientDesc(String clientDesc) {
		this.clientDesc = clientDesc;
	}

	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}
	
	public String getWhoUpdated() {
		return whoUpdated;
	}

	public void setWhoUpdated(String whoUpdated) {
		this.whoUpdated = whoUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (getClientId() != null)
			result = prime * result + (int) (getClientId() ^ (getClientId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AhiProjects))
			return false;
		AhiClients other = (AhiClients) obj;
		if (getClientId() != other.getClientId())
			return false;
		return true;
	}

}
