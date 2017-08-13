package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_module database table.
 * 
 */
@Entity
@Table(name="m_module")
@NamedQuery(name="MModule.findAll", query="SELECT m FROM MModule m")
public class MModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	private String url;

	//bi-directional many-to-many association to MGroup
	@ManyToMany
	@JoinTable(
		name="group_module"
		, joinColumns={
			@JoinColumn(name="module_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="group_id")
			}
		)
	private List<MGroup> MGroups;

	public MModule() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MGroup> getMGroups() {
		return this.MGroups;
	}

	public void setMGroups(List<MGroup> MGroups) {
		this.MGroups = MGroups;
	}

}