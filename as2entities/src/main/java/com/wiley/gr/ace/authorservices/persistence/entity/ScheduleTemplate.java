package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 7, 2015 5:39:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * ScheduleTemplate generated by hbm2java
 */
@Entity
@Table(name = "SCHEDULE_TEMPLATE")
public class ScheduleTemplate implements java.io.Serializable {

	private String scheduleId;
	private Template templateByOnscreenTmpl;
	private Schedule schedule;
	private Template templateByEmailTmpl;
	private Integer delay;

	public ScheduleTemplate() {
	}

	public ScheduleTemplate(Schedule schedule) {
		this.schedule = schedule;
	}

	public ScheduleTemplate(Template templateByOnscreenTmpl, Schedule schedule,
			Template templateByEmailTmpl, Integer delay) {
		this.templateByOnscreenTmpl = templateByOnscreenTmpl;
		this.schedule = schedule;
		this.templateByEmailTmpl = templateByEmailTmpl;
		this.delay = delay;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "schedule"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SCHEDULE_ID", unique = true, nullable = false)
	public String getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ONSCREEN_TMPL")
	public Template getTemplateByOnscreenTmpl() {
		return this.templateByOnscreenTmpl;
	}

	public void setTemplateByOnscreenTmpl(Template templateByOnscreenTmpl) {
		this.templateByOnscreenTmpl = templateByOnscreenTmpl;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL_TMPL")
	public Template getTemplateByEmailTmpl() {
		return this.templateByEmailTmpl;
	}

	public void setTemplateByEmailTmpl(Template templateByEmailTmpl) {
		this.templateByEmailTmpl = templateByEmailTmpl;
	}

	@Column(name = "DELAY", precision = 22, scale = 0)
	public Integer getDelay() {
		return this.delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

}
