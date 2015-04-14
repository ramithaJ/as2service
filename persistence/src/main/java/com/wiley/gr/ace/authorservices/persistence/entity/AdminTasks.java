package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_TASKS")
public class AdminTasks {
	@Id
	@Column(name="TASK_ID")
	private Integer taskId;
	
	@Column(name="TASK_NAME")
	private String taskName;
	
	@Column(name="TASK_ASSIGNED_TO")
	private String taskAssignedTo;
	
	@Column(name="TASK_LOCKED_BY")
	private String taskLockedBy;
	
	@Column(name="TASK_ASSIGNED_TO_USERID")
	private Integer taskAssignedToUserId;
	
	@Column(name="TASK_RECEVIED_DATE")
	private Date taskReceviedDate;
	
	@Column(name="TASK_COMPLETION_DATE")
	private Date taskCompletionDate;
	
	@Column(name="TASK_RECEVIED_FROM")
	private String taskReceviedFrom;
	
	@Column(name="TASK_ASSIGNED_BY")
	private String taskAssignedBy;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskAssignedTo() {
		return taskAssignedTo;
	}

	public void setTaskAssignedTo(String taskAssignedTo) {
		this.taskAssignedTo = taskAssignedTo;
	}

	public String getTaskLockedBy() {
		return taskLockedBy;
	}

	public void setTaskLockedBy(String taskLockedBy) {
		this.taskLockedBy = taskLockedBy;
	}

	public Integer getTaskAssignedToUserId() {
		return taskAssignedToUserId;
	}

	public void setTaskAssignedToUserId(Integer taskAssignedToUserId) {
		this.taskAssignedToUserId = taskAssignedToUserId;
	}

	public Date getTaskReceviedDate() {
		return taskReceviedDate;
	}

	public void setTaskReceviedDate(Date taskReceviedDate) {
		this.taskReceviedDate = taskReceviedDate;
	}

	public Date getTaskCompletionDate() {
		return taskCompletionDate;
	}

	public void setTaskCompletionDate(Date taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

	public String getTaskReceviedFrom() {
		return taskReceviedFrom;
	}

	public void setTaskReceviedFrom(String taskReceviedFrom) {
		this.taskReceviedFrom = taskReceviedFrom;
	}

	public String getTaskAssignedBy() {
		return taskAssignedBy;
	}

	public void setTaskAssignedBy(String taskAssignedBy) {
		this.taskAssignedBy = taskAssignedBy;
	}
	
	

}
