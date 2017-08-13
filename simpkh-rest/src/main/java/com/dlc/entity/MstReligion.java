package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_religion database table.
 * 
 */
@Entity
@Table(name="mst_religion")
@NamedQuery(name="MstReligion.findAll", query="SELECT m FROM MstReligion m")
public class MstReligion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="religion_name")
	private String religionName;

	public MstReligion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReligionName() {
		return this.religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

}