package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Test generated by hbm2java
 */
@Entity
@Table(name = "TEST")
public class Test implements java.io.Serializable {

	private TestId id;

	public Test() {
	}

	public Test(TestId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "a", column = @Column(name = "A", precision = 22, scale = 0)),
			@AttributeOverride(name = "b", column = @Column(name = "B")) })
	public TestId getId() {
		return this.id;
	}

	public void setId(TestId id) {
		this.id = id;
	}

}
