package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_jawaban database table.
 * 
 */
@Entity
@Table(name="mst_jawaban")
@NamedQuery(name="MstJawaban.findAll", query="SELECT m FROM MstJawaban m")
public class MstJawaban implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kode_jawaban")
	private String kodeJawaban;

	private String name;

	//bi-directional many-to-one association to MstSoal
	@ManyToOne
	@JoinColumn(name="kode_soal")
	private MstSoal mstSoal;

	public MstJawaban() {
	}

	public String getKodeJawaban() {
		return this.kodeJawaban;
	}

	public void setKodeJawaban(String kodeJawaban) {
		this.kodeJawaban = kodeJawaban;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MstSoal getMstSoal() {
		return this.mstSoal;
	}

	public void setMstSoal(MstSoal mstSoal) {
		this.mstSoal = mstSoal;
	}

}