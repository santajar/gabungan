package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sequence_table database table.
 * 
 */
@Entity
@Table(name="sequence_table")
@NamedQuery(name="SequenceTable.findAll", query="SELECT s FROM SequenceTable s")
public class SequenceTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sequence_name")
	private String sequenceName;

	@Column(name="sequence_next_hi_value")
	private Long sequenceNextHiValue;

	public SequenceTable() {
	}

	public String getSequenceName() {
		return this.sequenceName;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	public Long getSequenceNextHiValue() {
		return this.sequenceNextHiValue;
	}

	public void setSequenceNextHiValue(Long sequenceNextHiValue) {
		this.sequenceNextHiValue = sequenceNextHiValue;
	}

}