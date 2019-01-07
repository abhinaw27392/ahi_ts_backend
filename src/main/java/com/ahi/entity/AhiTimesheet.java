package com.ahi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ahi_timesheet")
public class AhiTimesheet {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@ManyToOne
	@JoinColumn(name = "task_id")
	AhiTasks task;

	@ManyToOne
	@JoinColumn(name = "project_id")
	AhiProjects project;
	
	@Column(name = "task_desc")
	private String taskDesc;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "total_hours")
	private Integer totalHours;

	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "who_updated")
	private String whoUpdated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AhiProjects getProject() {
		return project;
	}

	public void setProject(AhiProjects project) {
		this.project = project;
	}

	public AhiTasks getTask() {
		return task;
	}

	public void setTask(AhiTasks task) {
		this.task = task;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	public Integer getTotalHours() {
		return totalHours;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
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
		if (getId() != null)
			result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AhiTimesheet))
			return false;
		AhiTimesheet other = (AhiTimesheet) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

}
