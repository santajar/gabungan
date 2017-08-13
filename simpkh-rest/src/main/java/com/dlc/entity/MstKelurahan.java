package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_kelurahan database table.
 * 
 */
@Entity
@Table(name="mst_kelurahan")
@NamedQuery(name="MstKelurahan.findAll", query="SELECT m FROM MstKelurahan m")
public class MstKelurahan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kd_kelr")
	private Integer kdKelr;

	@Column(name="kelr_name")
	private String kelrName;

	//bi-directional many-to-one association to MPendamping
	@OneToMany(mappedBy="mstKelurahan")
	private List<MPendamping> MPendampings;

	//bi-directional many-to-one association to MstKecamatan
	@ManyToOne
	@JoinColumn(name="kd_kac")
	private MstKecamatan mstKecamatan;

	//bi-directional many-to-one association to TKpmResertifikasi
	@OneToMany(mappedBy="mstKelurahan")
	private List<TKpmResertifikasi> TKpmResertifikasis;

	public MstKelurahan() {
	}

	public Integer getKdKelr() {
		return this.kdKelr;
	}

	public void setKdKelr(Integer kdKelr) {
		this.kdKelr = kdKelr;
	}

	public String getKelrName() {
		return this.kelrName;
	}

	public void setKelrName(String kelrName) {
		this.kelrName = kelrName;
	}

	public List<MPendamping> getMPendampings() {
		return this.MPendampings;
	}

	public void setMPendampings(List<MPendamping> MPendampings) {
		this.MPendampings = MPendampings;
	}

	public MPendamping addMPendamping(MPendamping MPendamping) {
		getMPendampings().add(MPendamping);
		MPendamping.setMstKelurahan(this);

		return MPendamping;
	}

	public MPendamping removeMPendamping(MPendamping MPendamping) {
		getMPendampings().remove(MPendamping);
		MPendamping.setMstKelurahan(null);

		return MPendamping;
	}

	public MstKecamatan getMstKecamatan() {
		return this.mstKecamatan;
	}

	public void setMstKecamatan(MstKecamatan mstKecamatan) {
		this.mstKecamatan = mstKecamatan;
	}

	public List<TKpmResertifikasi> getTKpmResertifikasis() {
		return this.TKpmResertifikasis;
	}

	public void setTKpmResertifikasis(List<TKpmResertifikasi> TKpmResertifikasis) {
		this.TKpmResertifikasis = TKpmResertifikasis;
	}

	public TKpmResertifikasi addTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().add(TKpmResertifikasi);
		TKpmResertifikasi.setMstKelurahan(this);

		return TKpmResertifikasi;
	}

	public TKpmResertifikasi removeTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().remove(TKpmResertifikasi);
		TKpmResertifikasi.setMstKelurahan(null);

		return TKpmResertifikasi;
	}

}