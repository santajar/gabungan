package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_soal database table.
 * 
 */
@Entity
@Table(name="mst_soal")
@NamedQuery(name="MstSoal.findAll", query="SELECT m FROM MstSoal m")
public class MstSoal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kode_soal")
	private String kodeSoal;

	@Column(name="max_digit")
	private Integer maxDigit;

	private Integer ordered;

	private String question;

	private String type;

	//bi-directional many-to-one association to MstJawaban
	@OneToMany(mappedBy="mstSoal")
	private List<MstJawaban> mstJawabans;

	//bi-directional many-to-one association to MstSoal
	@ManyToOne
	@JoinColumn(name="parent_kode_soal")
	private MstSoal mstSoal;

	//bi-directional many-to-one association to MstSoal
	@OneToMany(mappedBy="mstSoal")
	private List<MstSoal> mstSoals;

	public MstSoal() {
	}

	public String getKodeSoal() {
		return this.kodeSoal;
	}

	public void setKodeSoal(String kodeSoal) {
		this.kodeSoal = kodeSoal;
	}

	public Integer getMaxDigit() {
		return this.maxDigit;
	}

	public void setMaxDigit(Integer maxDigit) {
		this.maxDigit = maxDigit;
	}

	public Integer getOrdered() {
		return this.ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<MstJawaban> getMstJawabans() {
		return this.mstJawabans;
	}

	public void setMstJawabans(List<MstJawaban> mstJawabans) {
		this.mstJawabans = mstJawabans;
	}

	public MstJawaban addMstJawaban(MstJawaban mstJawaban) {
		getMstJawabans().add(mstJawaban);
		mstJawaban.setMstSoal(this);

		return mstJawaban;
	}

	public MstJawaban removeMstJawaban(MstJawaban mstJawaban) {
		getMstJawabans().remove(mstJawaban);
		mstJawaban.setMstSoal(null);

		return mstJawaban;
	}

	public MstSoal getMstSoal() {
		return this.mstSoal;
	}

	public void setMstSoal(MstSoal mstSoal) {
		this.mstSoal = mstSoal;
	}

	public List<MstSoal> getMstSoals() {
		return this.mstSoals;
	}

	public void setMstSoals(List<MstSoal> mstSoals) {
		this.mstSoals = mstSoals;
	}

	public MstSoal addMstSoal(MstSoal mstSoal) {
		getMstSoals().add(mstSoal);
		mstSoal.setMstSoal(this);

		return mstSoal;
	}

	public MstSoal removeMstSoal(MstSoal mstSoal) {
		getMstSoals().remove(mstSoal);
		mstSoal.setMstSoal(null);

		return mstSoal;
	}

}