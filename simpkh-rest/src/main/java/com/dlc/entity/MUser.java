package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_user database table.
 * 
 */
@Entity
@Table(name="m_user")
@NamedQuery(name="MUser.findAll", query="SELECT m FROM MUser m")
public class MUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="account_enabled")
	private Boolean accountEnabled;

	@Column(name="account_expired")
	private Boolean accountExpired;

	@Column(name="account_locked")
	private Boolean accountLocked;

	@Column(name="credentials_expired")
	private Boolean credentialsExpired;

	private String kdkabu;

	private String kdkeca;

	private String kdkelr;

	private String kdprop;

	private String namauser;

	private String password;

	private String userid;

	//bi-directional many-to-one association to MPendamping
	@OneToMany(mappedBy="MUser")
	private List<MPendamping> MPendampings;

	//bi-directional many-to-many association to MGroup
	@ManyToMany
	@JoinTable(
		name="user_group"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="group_id")
			}
		)
	private List<MGroup> MGroups;

	public MUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAccountEnabled() {
		return this.accountEnabled;
	}

	public void setAccountEnabled(Boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	public Boolean getAccountExpired() {
		return this.accountExpired;
	}

	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public Boolean getAccountLocked() {
		return this.accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Boolean getCredentialsExpired() {
		return this.credentialsExpired;
	}

	public void setCredentialsExpired(Boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public String getKdkabu() {
		return this.kdkabu;
	}

	public void setKdkabu(String kdkabu) {
		this.kdkabu = kdkabu;
	}

	public String getKdkeca() {
		return this.kdkeca;
	}

	public void setKdkeca(String kdkeca) {
		this.kdkeca = kdkeca;
	}

	public String getKdkelr() {
		return this.kdkelr;
	}

	public void setKdkelr(String kdkelr) {
		this.kdkelr = kdkelr;
	}

	public String getKdprop() {
		return this.kdprop;
	}

	public void setKdprop(String kdprop) {
		this.kdprop = kdprop;
	}

	public String getNamauser() {
		return this.namauser;
	}

	public void setNamauser(String namauser) {
		this.namauser = namauser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<MPendamping> getMPendampings() {
		return this.MPendampings;
	}

	public void setMPendampings(List<MPendamping> MPendampings) {
		this.MPendampings = MPendampings;
	}

	public MPendamping addMPendamping(MPendamping MPendamping) {
		getMPendampings().add(MPendamping);
		MPendamping.setMUser(this);

		return MPendamping;
	}

	public MPendamping removeMPendamping(MPendamping MPendamping) {
		getMPendampings().remove(MPendamping);
		MPendamping.setMUser(null);

		return MPendamping;
	}

	public List<MGroup> getMGroups() {
		return this.MGroups;
	}

	public void setMGroups(List<MGroup> MGroups) {
		this.MGroups = MGroups;
	}

}