package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "ADMIN_TASKS")
public class AdminTasks implements java.io.Serializable {

	private Integer taskId;
	private String taskName;
	private String taskAssignedTo;
	private String taskLockedBy;
	private Integer taskAssignedToUserid;
	private Serializable taskReceviedDate;
	private Serializable taskCompletionDate;
	private String taskReceviedFrom;
	private String taskAssignedBy;

	public AdminTasks() {
	}

	public AdminTasks(Integer taskId) {
		this.taskId = taskId;
	}

	public AdminTasks(Integer taskId, String taskName,
			String taskAssignedTo, String taskLockedBy,
			Integer taskAssignedToUserid, Serializable taskReceviedDate,
			Serializable taskCompletionDate, String taskReceviedFrom,
			String taskAssignedBy) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskAssignedTo = taskAssignedTo;
		this.taskLockedBy = taskLockedBy;
		this.taskAssignedToUserid = taskAssignedToUserid;
		this.taskReceviedDate = taskReceviedDate;
		this.taskCompletionDate = taskCompletionDate;
		this.taskReceviedFrom = taskReceviedFrom;
		this.taskAssignedBy = taskAssignedBy;
	}

	@Id
	@Column(name = "TASK_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "TASK_NAME", length = 250)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "TASK_ASSIGNED_TO", length = 250)
	public String getTaskAssignedTo() {
		return this.taskAssignedTo;
	}

	public void setTaskAssignedTo(String taskAssignedTo) {
		this.taskAssignedTo = taskAssignedTo;
	}

	@Column(name = "TASK_LOCKED_BY", length = 250)
	public String getTaskLockedBy() {
		return this.taskLockedBy;
	}

	public void setTaskLockedBy(String taskLockedBy) {
		this.taskLockedBy = taskLockedBy;
	}

	@Column(name = "TASK_ASSIGNED_TO_USERID", precision = 22, scale = 0)
	public Integer getTaskAssignedToUserid() {
		return this.taskAssignedToUserid;
	}

	public void setTaskAssignedToUserid(Integer taskAssignedToUserid) {
		this.taskAssignedToUserid = taskAssignedToUserid;
	}

	@Column(name = "TASK_RECEVIED_DATE")
	public Serializable getTaskReceviedDate() {
		return this.taskReceviedDate;
	}

	public void setTaskReceviedDate(Serializable taskReceviedDate) {
		this.taskReceviedDate = taskReceviedDate;
	}

	@Column(name = "TASK_COMPLETION_DATE")
	public Serializable getTaskCompletionDate() {
		return this.taskCompletionDate;
	}

	public void setTaskCompletionDate(Serializable taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

	@Column(name = "TASK_RECEVIED_FROM", length = 250)
	public String getTaskReceviedFrom() {
		return this.taskReceviedFrom;
	}

	public void setTaskReceviedFrom(String taskReceviedFrom) {
		this.taskReceviedFrom = taskReceviedFrom;
	}

	@Column(name = "TASK_ASSIGNED_BY", length = 250)
	public String getTaskAssignedBy() {
		return this.taskAssignedBy;
	}

	public void setTaskAssignedBy(String taskAssignedBy) {
		this.taskAssignedBy = taskAssignedBy;
	}

}
