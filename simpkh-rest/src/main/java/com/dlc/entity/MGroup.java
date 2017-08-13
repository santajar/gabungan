package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the m_group database table.
 * 
 */
@Entity
@Table(name="m_group")
@NamedQuery(name="MGroup.findAll", query="SELECT m FROM MGroup m")
public class MGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String description;

	private String name;

	//bi-directional many-to-many association to MModule
	@ManyToMany(mappedBy="MGroups")
	private List<MModule> MModules;

	//bi-directional many-to-many association to MUser
	@ManyToMany(mappedBy="MGroups")
	private List<MUser> MUsers;

	public MGroup() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MModule> getMModules() {
		return this.MModules;
	}

	public void setMModules(List<MModule> MModules) {
		this.MModules = MModules;
	}

	public List<MUser> getMUsers() {
		return this.MUsers;
	}

	public void setMUsers(List<MUser> MUsers) {
		this.MUsers = MUsers;
	}

}